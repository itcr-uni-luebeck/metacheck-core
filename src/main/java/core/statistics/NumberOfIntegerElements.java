package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to return the number of dataelements of type integer of a
 * namespace from Samply.MDR
 * 
 * @author Alexandra Banach
 *
 */
public class NumberOfIntegerElements implements IStatistic {

	/**
	 * method to return the number of dataelements of type integer of a namespace
	 * from Samply.MDR
	 * 
	 * @param namespace of type MyNamespace from Samply.MDR
	 * @return number of datelements of type integer of namespace from Samply.MDR as
	 *         object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get dataelements of namespace and initialize variable to count integer
		// elements
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float countInteger = 0;

		// count number of integer elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("INTEGER")) {
				countInteger++;
			} else {

			}
		}

		return new Statistic("number of integer elements", "numInt", countInteger);
	}
}
