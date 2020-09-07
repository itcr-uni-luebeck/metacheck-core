package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of float and integer elements with unit of
 * measure
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfFloatIntElementsWithUnitOfMeasure implements IMetricNamespace {
	/**
	 * compute metric proportion of float and integer elements with unit of measure
	 * 
	 * @param namespace
	 * @return computed metric proportion of float and integer elements with unit of
	 *         measure
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// get all dataelements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfUnitsOfMeasure = 0;

		// count all elements without unit of measures and all int or float elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("INTEGER")
					|| de.getMyValidation().getDatatype().equals("FLOAT")) {
				if (!de.getMyValidation().getUnitOfMeasure().isEmpty()) {
					numberOfUnitsOfMeasure++;
				} else {

				}
			} else {

			}

		}

		// compute proportion and return it
		float weight = 0;
		float score = 1;
		if (dataelements.size() != 0) {
			// divide number of elements without unit of measure by number of all float and
			// int elements
			weight = (float) numberOfUnitsOfMeasure / dataelements.size();
		} else {
			// if there are no float or int dataelements the proportion is 0
		}

		return new Metric("completeness", "proportion of float and integer elements with units of measure",
				"propUnitOfMeasure", weight, score);
	}
}
