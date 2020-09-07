package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElementGroup;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of data element groups with number of
 * elements out of range (>10 or <2)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfGroupsWithNumberOfElementsOutOfRange implements IMetricNamespace {

	/**
	 * compute metric proportion of data element groups with number of elements
	 * 
	 * @param namespace
	 * @return computed metric proportion of data element groups with number of
	 *         elements
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElementGroup> groups = namespace.getMyDataElementGroup();
		int numberOfSubelements = 0;
		float groupsOutOfRange = 0;

		// check all data element groups
		for (MyDataElementGroup gr : groups) {
			// get number of subelements
			numberOfSubelements = gr.getSubelements().size();
			// check if number of subelements is out of range
			if (numberOfSubelements > 10 || numberOfSubelements < 2) {
				// if yes, increase counter
				groupsOutOfRange++;
			} else {

			}
		}

		// initialize
		float score = 0;
		float weight = 0;
		// compute weight
		if (groups.size() != 0) {
			weight = groupsOutOfRange / groups.size();
		} else {

		}

		// return result as Metric
		return new Metric("findability",
				"proportion of data element groups with number of elements greater than 10 or less than 2",
				"propGroupsWithElementsOutOfRange", weight, score);
	}
}
