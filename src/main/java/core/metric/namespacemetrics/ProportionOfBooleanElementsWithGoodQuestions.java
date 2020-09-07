package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of boolean elements with good questions
 * (definition contains at least ten words)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfBooleanElementsWithGoodQuestions implements IMetricNamespace {
	/**
	 * compute metric proportion of boolean elements with good questions (definition
	 * contains at least ten words)
	 * 
	 * @param namespace
	 * @return computed metric proportion of boolean elements with good questions
	 * 
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> elements = namespace.getMyDataElements();
		float elementsWithGoodQuestions = 0;
		String definition = null;

		// check each data element
		for (MyDataElement e : elements) {
			// check if type booolean
			if (e.getMyValidation().getDatatype().equals("BOOLEAN")) {
				// check all designation
				for (int i = 0; i < e.getMyDesignations().size(); i++) {
					definition = e.getMyDesignations().get(i).getDefinition();
					// increase counter if definition contains at least ten words
					if (definition.split(" ").length >= 10) {
						elementsWithGoodQuestions++;
					} else {

					}
				}

			} else {

			}

		}

		// initialize
		float score = 1;
		float weight = 0;
		// compute weight
		if (elements.size() != 0) {
			weight = elementsWithGoodQuestions / elements.size();
		} else {

		}

		// return result as Metric
		return new Metric("cognitive accessibility", "proportion of boolean elements with good questions",
				"probBooleanGoodQuestions", weight, score);
	}
}
