package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to compute the proportion of data elements of type String
 * of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfStringElements implements IStatistic {
	/**
	 * method to compute the proportion of String elements of all data elements of a
	 * namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of String elements of all data elements of a namespace as
	 *         object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {

		// take all data elements of namespace
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int counterString = 0;
		int numberDataelement = dataelements.size();

		// count data elements with type String
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("STRING")) {
				counterString++;
			} else {

			}
		}
		// compute proportion and return
		float result = 0;
		if (numberDataelement != 0) {
			// divide number of string elements by number of all elements
			result = (float) counterString / numberDataelement;
		} else {
			// if list of data elements is empty return proportion = 0
		}

		return new Statistic("proportion of String elements", "propString", result);
	}
}
