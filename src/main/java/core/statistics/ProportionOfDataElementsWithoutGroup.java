package core.statistics;

import core.model.MyNamespace;

/**
 * class with method to compute the proportion of data elements of a namespace
 * which do not belong to a data element group
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfDataElementsWithoutGroup implements IStatistic {
	/**
	 * method to compute the proportion of data elements of a namespace which do not
	 * belong to a data element group. It is calculated by dividing the number of
	 * data elements without a group by the number of all data elements of the
	 * namespace.
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of data elements without data element group as object of
	 *         type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get number of data elements without a group which corresponds to
		// direct subelements of the namespace
		int numberOfDataElementsWithoutGroup = namespace.getSubelements().size();
		// get total number of data elements of a namespace
		int numberOfAllDataElements = namespace.getMyDataElements().size();

		// compute proportion and return
		float result = 0;
		// if the namespace has some data elements
		if (numberOfAllDataElements != 0) {
			// the proportion is the number of data elements without a group
			// divided by the number of all data elements
			result = (float) numberOfDataElementsWithoutGroup / numberOfAllDataElements;
		} else {
			// if there are no data elements the proportion is 0 as initialized result
		}

		return new Statistic("proportion of dataelements without group", "propElementsWithoutGroup", result);
	}
}
