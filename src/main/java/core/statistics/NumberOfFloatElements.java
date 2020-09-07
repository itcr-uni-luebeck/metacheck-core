package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to return the number of float elements of a namespace from
 * Samply.MDR
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfFloatElements implements IStatistic {

	/**
	 * method to return the number of float elements of a namespace from Samply.MDR
	 * 
	 * @param namespace of type MyNamespace from Samply.MDR
	 * @return number of dataelements of type float of namespace from Samply.MDR as
	 *         object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get dataelements of namespace and initialize variable to count float elements
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float countFloat = 0;

		// count number of float elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("FLOAT")) {
				countFloat++;
			} else {

			}
		}

		return new Statistic("number of float elements", "numFloat", countFloat);
	}
}
