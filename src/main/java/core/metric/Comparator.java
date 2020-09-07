package core.metric;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

import core.fetcher.DataFetcher;
import core.metric.exceptions.AmbiguousNamespaceException;
import core.metric.exceptions.DivisionByZeroException;
import core.metric.exceptions.InvalidNamespaceException;
import core.metric.exceptions.MaxScoreSmallerElementScoreException;
import de.samply.common.mdrclient.MdrConnectionException;
import de.samply.common.mdrclient.MdrInvalidResponseException;
/**
 * class with method to get data for two namespaces of Samply.MDR
 * and to calculate all metrics for them as comparison.
 * @author Alexandra Banach
 *
 */
public class Comparator {
	/**
	 * method to get data for two namespaces of Samply.MDR
	 * and to calculate all metrics for them as comparison.
	 * @param data1: data of first namespace: url, name, language
	 * @param data2: data of second namespace: url, name, language
	 * @return comparison of two namespaces 
	 * @throws IOException might appear while getting all classes of a package to find methods to compute metrics
	 * @throws InstantiationException might appear while creating an instance to call a method to compute a datalementscore
	 * @throws InvocationTargetException might appear while getting all methods to calculate dataelementscore for metrics 
	 * @throws IllegalArgumentException might appear while getting all methods to calculate dataelementscore for metrics
	 * @throws IllegalAccessException might appear while getting all methods to calculate dataelementscore for metrics
	 * @throws ClassNotFoundException  might appear while getting all classes of a package to find methods to compute metrics 
	 * @throws MdrInvalidResponseException is thrown if getting data for dataelements from Samply.MDR is not possible
	 * @throws MdrConnectionException is thrown if connection to Samply.MDR is not possible
	 * @throws ExecutionException is thrown if there is no connection to Samply.MDR
	 * @throws AmbiguousNamespaceException might appear if there are two namespaces with the same name
	 * @throws InvalidNamespaceException might appear if a namespace for a given name cannot be found
	 * @throws MaxScoreSmallerElementScoreException 
	 * @throws DivisionByZeroException 
	 */
		public static Comparison compare(DataFetcher data1, DataFetcher data2) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException, IOException, InvalidNamespaceException, AmbiguousNamespaceException, ExecutionException, MdrConnectionException, MdrInvalidResponseException, DivisionByZeroException, MaxScoreSmallerElementScoreException {
			// initialize two objects of type MetricsCalculator
			MetricsCalculator calculator1 = MetricsCalculator.getCalculator();
			MetricsCalculator calculator2 = MetricsCalculator.getCalculator();
			
			
			// use object to get overview for both data objects
			Overview overview1 = calculator1.evaluate(data1);
			Overview overview2 = calculator2.evaluate(data2);
			
			
			// return both overviews as comparison
			return new Comparison(overview1, overview2);
		}
}
