package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of enumeration with number of elements in
 * range (>= 3 and <= 10)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfEnumerationWithNumberOfElementsInRange implements IMetricNamespace {
	/**
	 * compute metric proportion of enumeration with number of elements in range (>=
	 * 3 and <= 10)
	 * 
	 * @param namespace
	 * @return computed metric proportion of enumeration with number of elements in
	 *         range (>= 3 and <= 10)
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> elements = namespace.getMyDataElements();
		float numElementsInRange = 0;

		// for each element
		for (MyDataElement e : elements) {
			// check if datatype is enumeration
			if (e.getMyValidation().getDatatype().equals("enumerated")) {
				// check if number of keys is between 3 and 10
				if (e.getMyValidation().getPermissibleValues().size() >= 3
						&& e.getMyValidation().getPermissibleValues().size() <= 10) {
					// if yes, increase counter
					numElementsInRange++;
				} else {

				}
			} else {

			}
		}

		// initialize
		float weight = 0;
		float score = 0;
		// compute weight
		if (elements.size() != 0) {
			weight = numElementsInRange / elements.size();
		} else {

		}

		// return result as Metric
		return new Metric("consistency",
				"proportion of enumeration with number of elements greater or equal 3 and less than or equal 10",
				"propEnumsInRange", weight, score);
	}
}
