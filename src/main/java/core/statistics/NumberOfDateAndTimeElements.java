package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to return the number of dataelements of type date or time
 * of a namespace from Samply.MDR
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfDateAndTimeElements implements IStatistic {
	/**
	 * method to return the number of dataelements of type date or time of a
	 * namespace from Samply.MDR
	 * 
	 * @param namespace of type MyNamespace from Samply.MDR
	 * @return number of dataelements of type date or time of a namespace as object
	 *         of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get dataelement for namespace and initialize variable to count date and time
		// dataelements
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float countDateTime = 0;

		/// count number of date and time elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("DATE")
					|| de.getMyValidation().getDatatype().equals("DATETIME")
					|| de.getMyValidation().getDatatype().equals("TIME")) {
				countDateTime++;
			} else {

			}
		}

		return new Statistic("number of date and time elements", "numDateTime", countDateTime);
	}
}
