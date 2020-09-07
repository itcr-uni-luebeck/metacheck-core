package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of date and time data elements
 * of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfDateAndTimeElements implements IStatistic {
	/**
	 * method to calculate the proportion of date and time data elements of a
	 * namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of date and time elements as object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all data elements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfDataElements = dataelements.size();
		int countDateTime = 0;

		// count number of date and time elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("DATE")
					|| de.getMyValidation().getDatatype().equals("DATETIME")
					|| de.getMyValidation().getDatatype().equals("TIME")) {
				countDateTime++;
			} else {

			}
		}
		// compute and return result
		float result = 0;
		if (numberOfDataElements != 0) {
			// divide number of date and time elements by number of all data elements
			result = (float) countDateTime / numberOfDataElements;
		} else {
			// if namespace has no data elements the result is 0
		}

		return new Statistic("proportion of date and time elements", "propDateTime", result);
	}
}
