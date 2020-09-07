package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of boolean data elements of a
 * namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfBooleanElements implements IStatistic {
	/**
	 * method to calculate the proportion of boolean data elements of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of boolean data elements of a namespace as object of type
	 *         Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all data elements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfDataElements = dataelements.size();
		int countBool = 0;

		// count number of boolean data elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("BOOLEAN")) {
				countBool++;
			} else {

			}
		}
		// compute and return result
		float result = 0;
		if (numberOfDataElements != 0) {
			// divide number of boolean elements by number of all data elements
			result = (float) countBool / numberOfDataElements;
		} else {
			// if namespace has no data elements the result is 0
		}

		return new Statistic("proportion of boolean elements", "propBool", result);
	}
}
