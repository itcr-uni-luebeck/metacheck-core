package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with a method which returns the number of data elements of type String
 * of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfStringElements implements IStatistic {
	/**
	 * method which returns the number of data elements of type String of a
	 * namespace
	 * 
	 * @param namespace of type MyNamespace from Samply.MDR
	 * @return number of data elements of type String as object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get data elements and initialize variable to count String elements
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float countString = 0;

		/// count number of String elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("STRING")) {
				countString++;
			} else {

			}
		}

		return new Statistic("number of String elements", "numString", countString);
	}
}
