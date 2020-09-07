package core.statistics;

import core.model.MyNamespace;

/**
 * interface for all methods that calculate statistics of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public interface IStatistic {
	/**
	 * method to compute statistic of a namespace
	 * 
	 * @param namespace
	 * @return computed statistic
	 */
	Statistic calculate(MyNamespace namespace);
}
