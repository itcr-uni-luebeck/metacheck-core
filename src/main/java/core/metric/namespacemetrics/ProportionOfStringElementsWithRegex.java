package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of String elements with regex
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfStringElementsWithRegex implements IMetricNamespace {

	/**
	 * compute metric proportion of String elements with regex
	 * 
	 * @param namespace
	 * @return computed metric proportion of String elements with regex
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// take all dataelements of namespace, initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfElements = dataelements.size();
		int countRegexElements = 0;

		// count number of String elements and number of them without REGEX
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("STRING") && de.getMyValidation().getValidationData() != null
					&& !de.getMyValidation().getValidationData().isEmpty()) {
				countRegexElements++;
			} else {

			}

		}

		// compute proportion and return
		float weight = 0;
		float score = 1;
		if (numberOfElements != 0) {
			// divide number of string elements without regex by number of all string
			// elements
			weight = (float) countRegexElements / numberOfElements;
		} else {
			// if there are no String elements the proportion is 0
		}

		return new Metric("consistency", "proportion of String elements with REGEX", "stringWithRegex", weight, score);
	}
}
