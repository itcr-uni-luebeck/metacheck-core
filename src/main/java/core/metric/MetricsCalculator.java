package core.metric;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import core.fetcher.DataFetcher;
import core.metric.exceptions.AmbiguousNamespaceException;
import core.metric.exceptions.DivisionByZeroException;
import core.metric.exceptions.InvalidNamespaceException;
import core.metric.exceptions.MaxScoreSmallerElementScoreException;
import core.metric.namespacemetrics.CalculateNamespaceScore;
import core.metric.namespacemetrics.Metric;
import core.metric.reflections.MethodWithClass;
import core.metric.reflections.ReflectionHelper;
import core.model.MyNamespace;
import core.statistics.Statistic;
import de.samply.common.mdrclient.MdrConnectionException;
import de.samply.common.mdrclient.MdrInvalidResponseException;


/**
 * class to evaluate namespace from samply.mdr
 * designed as singleton pattern
 * @author Alexandra Banach
 *
 */
public final class MetricsCalculator {
	
	// initialize single instance of class
	private static final MetricsCalculator calculator = new MetricsCalculator();
	
	/**private constructor for single object of type MetricsCalculator */
	private MetricsCalculator() {}
	
	/**
	 * static getter for single object of type MetricsCalculator
	 * @return calculator of type MetricsCalculator
	 */
	public static MetricsCalculator getCalculator() {
		return calculator;
	}

		
	/**
	 * method to evaluate namespace:
	 * get data from samply.mdr and
	 * calculate metrics
	 * @param myData as object of type Data: url of samply.mdr and namespace
	 * @return calculated metrics for namespace as object of type Overview 
	 * @throws IOException might appear while getting all classes of a package to find methods to compute metrics
	 * @throws ClassNotFoundException might appear while getting all classes of a package to find methods to compute metrics
	 * @throws InstantiationException might appear while creating an instance to call a method to compute a datalementscore
	 * @throws InvocationTargetException might appear while getting all methods to calculate dataelementscore for metrics
	 * @throws IllegalArgumentException might appear while getting all methods to calculate dataelementscore for metrics
	 * @throws IllegalAccessException might appear while getting all methods to calculate dataelementscore for metrics
	 * @throws MdrInvalidResponseException is thrown if getting data for dataelements from Samply.MDR is not possible
	 * @throws MdrConnectionException is thrown if connection to Samply.MDR is not possible
	 * @throws ExecutionException is thrown if there is no connection to Samply.MDR
	 * @throws AmbiguousNamespaceException might appear if there are two namespaces with the same name
	 * @throws InvalidNamespaceException might appear if a namespace for a given name cannot be found
	 * @throws MaxScoreSmallerElementScoreException 
	 * @throws DivisionByZeroException 
	 */
	public Overview evaluate(DataFetcher myData) throws ClassNotFoundException, IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, InvalidNamespaceException, AmbiguousNamespaceException, ExecutionException, MdrConnectionException, MdrInvalidResponseException, DivisionByZeroException, MaxScoreSmallerElementScoreException {
		
		// get dataelements of namespace
		MyNamespace myNamespace = myData.getMyData(myData);
		
	   
		// get all calculate methods from packages for metrics and statistics
	    List<MethodWithClass> calculateMetricsMethods = ReflectionHelper.getMethodsByNameFromPackage("calculate", "core.metric.namespacemetrics", "IMetricNamespace");
	    List<MethodWithClass> calculateStatisticsMethods = ReflectionHelper.getMethodsByNameFromPackage("calculate", "core.statistics", "IStatistic");
	    
	    // lists for returning result
	    List<Metric> metrics = new ArrayList<Metric>();
	    List<Statistic> statistics = new ArrayList<Statistic>();
	    
	    
	    // call all calculate methods to calculate metrics for namespace
	    for(int i = 0; i< calculateMetricsMethods.size(); i++) {
	    	metrics.add((Metric) calculateMetricsMethods.get(i).getMyMethod().invoke(calculateMetricsMethods.get(i).getMyClass().newInstance(), myNamespace));	    	
		}
	    
	    // call all calculate methods to calculate statistics for namespace
	    for(int i = 0; i< calculateStatisticsMethods.size(); i++) {
	    	statistics.add((Statistic) calculateStatisticsMethods.get(i).getMyMethod().invoke(calculateStatisticsMethods.get(i).getMyClass().newInstance(), myNamespace));	    	
		}
	    
	    // compute namespace score
	    CalculateNamespaceScore score = new CalculateNamespaceScore();
	    float namespaceScore = score.calculateScore(metrics);
	    
		return new Overview(myData.getUrl(), myNamespace, false, metrics, statistics, namespaceScore);
	}
}
