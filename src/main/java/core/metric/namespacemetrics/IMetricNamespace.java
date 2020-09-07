package core.metric.namespacemetrics;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import core.metric.exceptions.DivisionByZeroException;
import core.metric.exceptions.MaxScoreSmallerElementScoreException;
import core.model.MyNamespace;

/**
 * interface for all methods that calculate metrics of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public interface IMetricNamespace {
	/**
	 * method to calculate metric score of a namespace
	 * 
	 * @param myNamespace
	 * @return Metric score
	 * @throws MaxScoreSmallerElementScoreException is thrown if a dataelement has a
	 *                                              greater score than the maximum
	 *                                              possible
	 * @throws DivisionByZeroException              is thrown if division by zero
	 *                                              appears while computing a metric
	 * @throws InstantiationException               might appear while creating an
	 *                                              instance to call a method to
	 *                                              compute a datalementscore
	 * @throws InvocationTargetException            might appear while getting all
	 *                                              methods to calculate
	 *                                              dataelementscore for metrics
	 * @throws IllegalArgumentException             might appear while getting all
	 *                                              methods to calculate
	 *                                              dataelementscore for metrics
	 * @throws IllegalAccessException               might appear while getting all
	 *                                              methods to calculate
	 *                                              dataelementscore for metrics
	 * @throws IOException                          might appear while getting all
	 *                                              classes of a package to find
	 *                                              methods to compute metrics
	 * @throws ClassNotFoundException               might appear while getting all
	 *                                              classes of a package to find
	 *                                              methods to compute metrics
	 */
	Metric calculate(MyNamespace namespace)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException,
			DivisionByZeroException, MaxScoreSmallerElementScoreException, ClassNotFoundException, IOException;
}
