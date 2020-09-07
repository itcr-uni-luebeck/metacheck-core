package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of elements with ratio of definition and
 * designation value in range (>=2)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfElementsWithRatioOfDefinitionAndDesignationValueInRange implements IMetricNamespace {
	/**
	 * compute metric proportion of elements with ratio of definition and
	 * designation value in range (>=2)
	 * 
	 * @param namespace
	 * @return computed metric proportion of elements with ratio of defintion and
	 *         designation value in range (>=2)
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> elements = namespace.getMyDataElements();
		String definition = null;
		String designation = null;
		float elementsInRange = 0;

		// check all elements
		for (MyDataElement e : elements) {
			// get definition and designation length for each element
			for (int i = 0; i < e.getMyDesignations().size(); i++) {
				definition = e.getMyDesignations().get(i).getDefinition();
				designation = e.getMyDesignations().get(i).getDesignation();
			}
			// if ratio definition designation length at least 2, increase counter
			if ((float) definition.length() / designation.length() >= 2) {
				elementsInRange++;
			} else {

			}
		}

		// initialize
		float score = 1;
		float weight = 0;
		// compute weight
		if (elements.size() != 0) {
			weight = elementsInRange / elements.size();
		} else {

		}

		// return result as Metric
		return new Metric("coherence/ cognitive accessibility",
				"proportion of elements with ratio of definition and designation value >= 2", "propDefDesInRange",
				weight, score);
	}
}
