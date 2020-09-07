package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute proportion of enumerations with number of elements out of
 * range (<3 or >10)
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfEnumerationWithNumberOfElementsOutOfRange implements IMetricNamespace {

	/**
	 * compute proportion of enumerations with number of elements out of range (<3
	 * or >10)
	 * 
	 * @param namespace
	 * @return computed metric proportion of enumerations with number of elements
	 *         out of range (<3 or >10)
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> elements = namespace.getMyDataElements();
		float numElementsOutOfRange = 0;
		// for each element
		for (MyDataElement e : elements) {
			// check if data type is enumeration
			if (e.getMyValidation().getDatatype().equals("enumerated")) {
				// check if number of keys is out of range
				if (e.getMyValidation().getPermissibleValues().size() < 3
						|| e.getMyValidation().getPermissibleValues().size() > 10) {
					// if yes, increase counter
					numElementsOutOfRange++;
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
			weight = numElementsOutOfRange / elements.size();
		} else {

		}

		// return result as Metric
		return new Metric("consistency",
				"proportion of enumeration with number of elements less than 3 or more than 10", "propEnumsOutOfRange",
				weight, score);
	}

}
