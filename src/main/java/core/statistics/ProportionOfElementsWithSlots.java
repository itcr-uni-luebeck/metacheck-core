package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of data elements with a slot of
 * a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfElementsWithSlots implements IStatistic {
	/**
	 * method to calculate the proportion of data elements with a slot of a
	 * namespace. The proportion is calculated by dividing the number of elements
	 * with slot by the number of all elements
	 * 
	 * @param namespace of type MyNamespace
	 * @return proportion of data elements with slot as object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all data elements of namespace and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfDataElements = dataelements.size();
		int numberOfSlotElements = 0;

		// count number of data elements with slot
		for (MyDataElement de : dataelements) {
			if (!de.getMySlots().isEmpty()) {
				numberOfSlotElements++;
			} else {

			}
		}

		// compute result and return
		float result = 0;

		if (numberOfDataElements != 0) {
			// divide number of data elements with slot by number of all data elements
			result = (float) numberOfSlotElements / numberOfDataElements;
		} else {
			// if there are no data elements the result is 0
		}

		return new Statistic("proportion of dataelements with slot", "propElementsSlot", result);
	}
}
