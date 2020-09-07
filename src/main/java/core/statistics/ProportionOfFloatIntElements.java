package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to compute the proportion of integer and float data
 * elements of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfFloatIntElements implements IStatistic {
	/**
	 * method to compute the proportion of integer and float data elements of a
	 * namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of integer and float data elements of a namespace as
	 *         object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all data elements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfDataElements = dataelements.size();
		int countIntFloat = 0;

		// count number of float and integer elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("INTEGER")
					|| de.getMyValidation().getDatatype().equals("FLOAT")) {
				countIntFloat++;
			} else {

			}
		}
		// compute and return result
		float result = 0;
		if (numberOfDataElements != 0) {
			// divide number of float and int elements by number of all data elements
			result = (float) countIntFloat / numberOfDataElements;
		} else {
			// if namespace has no data elements the result is 0
		}

		return new Statistic("proportion of integer and float elements", "propIntFloat", result);
	}
}
