package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute the average number of different slot keys of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class AverageNumberOfDifferentSlotKeys implements IStatistic {
	/**
	 * compute average number of diffent slot keys of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed statistic average number of different slot keys of a
	 *         namespace
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfSlots = 0;
		int numberOfSlotElements = 0;

		// for each data element
		for (MyDataElement de : dataelements) {
			// check number of slots and count them, count also number of data elements with
			// slot
			if (!de.getMySlots().isEmpty()) {
				numberOfSlots += de.getMySlots().size();
				numberOfSlotElements++;
			} else {

			}
		}

		// compute result
		float result = 0;
		if (numberOfSlotElements != 0) {
			result = (float) numberOfSlots / numberOfSlotElements;
		} else {

		}

		// return result as Statistic
		return new Statistic("average number of different slot key", "averageSlotKeys", result);
	}
}
