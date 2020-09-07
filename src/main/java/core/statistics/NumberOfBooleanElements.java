package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to return the number of dataelements of type boolean of a
 * namespace from Samply.MDR
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfBooleanElements implements IStatistic {
	/**
	 * method to return the number of dataelements of type boolean of a namespace
	 * from Samply.MDR
	 * 
	 * @param namespace of type MyNamespace from Samply.MDR
	 * @return number of dataelements of type Boolean as object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get dataelements of namespace and initialize variable to count boolean
		// elements
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float countBool = 0;

		// count number of boolean dataelements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("BOOLEAN")) {
				countBool++;
			} else {

			}
		}

		return new Statistic("number of boolean elements", "numBool", countBool);
	}
}
