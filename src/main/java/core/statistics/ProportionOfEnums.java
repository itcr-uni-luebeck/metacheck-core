package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of enumeration data elements of
 * a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfEnums implements IStatistic {
	/**
	 * method to calculate the proportion of enumeration data elements of a
	 * namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of enumeration data elements of a namespace as object of
	 *         type Statistic
	 */
	public Statistic calculate(MyNamespace namespace) {
		// get all data elements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfDataElements = dataelements.size();
		int countEnums = 0;

		// count number of Enums
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("enumerated")) {
				countEnums++;
			} else {

			}
		}
		// compute and return result
		float result = 0;
		if (numberOfDataElements != 0) {
			// divide number of enumeration elements by number of all data elements
			result = (float) countEnums / numberOfDataElements;
		} else {
			// if namespace has no data elements the result is 0
		}

		return new Statistic("proportion of enumerations", "propEnums", result);
	}
}
