package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute the proportion of data elements without slot of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfElementsWithoutSlots implements IStatistic {

	/**
	 * compute the proportion of data elements without slot of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed statistic proportion of data elements without slot
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all data elements of namespace and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfDataElements = dataelements.size();
		int numberOfElementsWithoutSlot = 0;

		// count number of data elements with slot
		for (MyDataElement de : dataelements) {
			if (de.getMySlots().isEmpty()) {
				numberOfElementsWithoutSlot++;
			} else {

			}
		}

		// compute result and return
		float result = 0;

		if (numberOfDataElements != 0) {
			// divide number of data elements with slot by number of all data elements
			result = (float) numberOfElementsWithoutSlot / numberOfDataElements;
		} else {
			// if there are no data elements the result is 0
		}

		return new Statistic("proportion of dataelements without slot", "propElementsWithoutSlot", result);
	}
}
