package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to return the number of dataelements of type enumeration
 * from Samply.MDR
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfEnumerationElements implements IStatistic {
	/**
	 * method to return the number of dataelements of type enumeration from
	 * Samply.MDR
	 * 
	 * @param namespace of type MyNamespace from Samly.MDR
	 * @return number of dataelements of type enumeration for a namespace from
	 *         Samply.MDR as object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float countEnums = 0;

		// count number of enumeration dataelements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("enumerated")) {
				countEnums++;
			} else {

			}
		}

		return new Statistic("number of enumeration elements", "numEnums", countEnums);
	}
}
