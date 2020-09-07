package core.statistics;

import core.model.MyNamespace;

/**
 * class to compute the proportion of data elements that belong to a data
 * element group of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfDataElementsWithGroup implements IStatistic {
	/**
	 * compute the proportion of data elements that belong to a data element group
	 * of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed statistic proportion of data elements with a group
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get number of data elements without a group which corresponds to
		// direct subelements of the namespace
		int numberOfDataElementsWithoutGroup = namespace.getSubelements().size();
		// get total number of data elements of a namespace
		int numberOfAllDataElements = namespace.getMyDataElements().size();
		int numberOfDataElementsWithGroup = numberOfAllDataElements - numberOfDataElementsWithoutGroup;

		// compute proportion and return
		float result = 0;
		// if the namespace has some data elements
		if (numberOfAllDataElements != 0) {
			// the proportion is the number of data elements without a group
			// divided by the number of all datalements
			result = (float) numberOfDataElementsWithGroup / numberOfAllDataElements;
		} else {
			// if there are no data elements the proportion is 0 as initialized result
		}

		return new Statistic("proportion of dataelements with group", "propElementsWithGroup", result);
	}
}
