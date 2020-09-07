package core.statistics;

import core.model.MyNamespace;

/**
 * class with method which returns the total number of dataelements of a
 * namespace
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfDataElements implements IStatistic {
	/**
	 * method which return the total number of dataelements of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return total number of dataelements of a namespace as object of type
	 *         Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get number of dataelements and return it
		float result = namespace.getMyDataElements().size();

		return new Statistic("total number of dataelements", "numElements", result);
	}
}
