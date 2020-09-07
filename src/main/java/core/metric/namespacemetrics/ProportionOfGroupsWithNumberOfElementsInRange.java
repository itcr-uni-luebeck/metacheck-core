package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElementGroup;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of data element groups with number of
 * elements in range (<= 10 and >=2)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfGroupsWithNumberOfElementsInRange implements IMetricNamespace {

	/**
	 * compute metric proportion of data element groups with number of elements in
	 * range (<= 10 and >=2)
	 * 
	 * @param namespace
	 * @return computed metric proportion of data element groups with number of
	 *         elements in range (<= 10 and >=2)
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElementGroup> groups = namespace.getMyDataElementGroup();
		int numberOfSubelements = 0;
		float groupsInRange = 0;

		// for each data element group
		for (MyDataElementGroup gr : groups) {
			// get number of subelements
			numberOfSubelements = gr.getSubelements().size();
			// check if number of subelements is an range
			if (numberOfSubelements <= 10 && numberOfSubelements >= 2) {
				// if yes, increase counter
				groupsInRange++;
			} else {

			}
		}

		// initialize
		float score = 1;
		float weight = 0;
		// compute weight
		if (groups.size() != 0) {
			weight = groupsInRange / groups.size();
		} else {

		}

		// return result als Metric
		return new Metric("findability",
				"proportion of data element groups with number of elements less than or equal 10 and greater or equal 2",
				"propGroupsWithElementsInRange", weight, score);
	}
}
