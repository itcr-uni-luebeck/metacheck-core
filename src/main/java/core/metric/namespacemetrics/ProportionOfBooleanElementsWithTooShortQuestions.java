package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of boolean elements with too short
 * questions (definition contains less than ten words)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfBooleanElementsWithTooShortQuestions implements IMetricNamespace {

	/**
	 * compute metric proportion of boolean elements with too short questions
	 * (definition contains less than ten words)
	 * 
	 * @param namespace
	 * @return computed metric proportion of boolean elements with too short
	 *         questions
	 * 
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> elements = namespace.getMyDataElements();
		float elementsWithTooShortQuestions = 0;
		String definition = null;

		// check all elements
		for (MyDataElement e : elements) {
			// check if type boolean
			if (e.getMyValidation().getDatatype().equals("BOOLEAN")) {
				// check all definitions
				for (int i = 0; i < e.getMyDesignations().size(); i++) {
					definition = e.getMyDesignations().get(i).getDefinition();
					// if definition contains less than 10 words, increase counter
					if (definition.split(" ").length < 10) {
						elementsWithTooShortQuestions++;
					} else {

					}
				}

			} else {

			}

		}

		// initialize
		float score = 0;
		float weight = 0;
		// compute weight
		if (elements.size() != 0) {
			weight = elementsWithTooShortQuestions / elements.size();
		} else {

		}

		// return result as Metric
		return new Metric("cognitive accessibility", "proportion of boolean elements with too short questions",
				"probBooleanShortQuestions", weight, score);
	}
}
