package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of string elements with regular
 * expression (regex)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfStringElementsWithoutRegex implements IMetricNamespace {
	/**
	 * Method to calculate the proportion of string elements without regular
	 * expression of a namespace. The proportion is calculated by dividing the
	 * number of string elements without regex by the number of all string elements
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed metric proportion of string elements with regular expression
	 *         (regex)
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// take all dataelements of namespace, initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfElements = dataelements.size();
		int countNoRegexElements = 0;

		// count number of String elements and number of them without REGEX
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("STRING")) {
				if (de.getMyValidation().getValidationData() == null
						|| de.getMyValidation().getValidationData().isEmpty()) {
					countNoRegexElements++;
				}

			}

		}

		// compute proportion and return
		float weight = 0;
		float score = 0;
		if (numberOfElements != 0) {
			// divide number of string elements without regex by number of all string
			// elements
			weight = (float) countNoRegexElements / numberOfElements;
		} else {
			// if there are no String elements the proportion is 0
		}

		return new Metric("consistency", "proportion of String elements without REGEX", "stringWithoutRegex", weight,
				score);
	}
}
