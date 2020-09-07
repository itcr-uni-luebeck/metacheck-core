package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute proportion of elements with ratio of definition and
 * designation value out of range (<2)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfElementsWithRatioOfDefinitionAndDesignationValueOutOfRange implements IMetricNamespace {
	/**
	 * compute proportion of elements with ratio of definition and designation value
	 * out of range (<2)
	 * 
	 * @param namespace
	 * @return computed metric proportion of elements with ratio of definition and
	 *         designation value out of range (<2)
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> elements = namespace.getMyDataElements();
		String definition = null;
		String designation = null;
		float elementsOutOfRange = 0;

		// for each data elements
		for (MyDataElement e : elements) {
			// get definition and designation
			for (int i = 0; i < e.getMyDesignations().size(); i++) {
				definition = e.getMyDesignations().get(i).getDefinition();
				designation = e.getMyDesignations().get(i).getDesignation();
			}
			// check if ratio of length of definition and designation is smaller than 2
			if ((float) definition.length() / designation.length() < 2) {
				// if yes, increase counter
				elementsOutOfRange++;
			} else {

			}
		}

		// initialize
		float score = 0;
		float weight = 0;
		// comppute weight
		if (elements.size() != 0) {
			weight = elementsOutOfRange / elements.size();
		} else {

		}

		// return result as Metric
		return new Metric("coherence/ cognitive accessibility",
				"proportion of elements with ratio of definition and designation value < 2", "propDefDesOutOfRange",
				weight, score);
	}
}
