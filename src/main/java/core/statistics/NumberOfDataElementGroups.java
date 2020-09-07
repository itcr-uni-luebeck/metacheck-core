package core.statistics;

import core.model.MyNamespace;

/**
 * class with a method which returns the number of dataelementgroups of a
 * namespace
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfDataElementGroups implements IStatistic {
	/**
	 * method which returns the total number of dataelementgroups of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return number of dataelementgroups of a namespace as object of type
	 *         Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// calculate number of dataelementgroups and return it
		float result = namespace.getMyDataElementGroup().size();

		return new Statistic("total number of dataelementgroups", "numGroups", result);
	}
}
