package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of dataelements without a unit
 * of measure in a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfFloatIntElementsWithoutUnitOfMeasure implements IMetricNamespace {
	/**
	 * method to calculate the proportion of dataelements without a unit of measure
	 * in a namespace. The proportion is calculated by dividing the number of float
	 * and integer elements without unit of measure by the number of all float and
	 * integer elements
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed metric proportion of data elements without a unit of measure
	 *         in a namespace
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// get all dataelements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfNoUnitsOfMeasure = 0;

		// count all elements without unit of measures and all int or float elements
		for (MyDataElement de : dataelements) {
			if (de.getMyValidation().getDatatype().equals("INTEGER")
					|| de.getMyValidation().getDatatype().equals("FLOAT")) {
				if (de.getMyValidation().getUnitOfMeasure().isEmpty()) {
					numberOfNoUnitsOfMeasure++;
				} else {

				}
			} else {

			}

		}

		// compute proportion and return it
		float weight = 0;
		float score = 0;
		if (dataelements.size() != 0) {
			// divide number of elements without unit of measure by number of all float and
			// int elements
			weight = (float) numberOfNoUnitsOfMeasure / dataelements.size();
		} else {
			// if there are no float or int dataelements the proportion is 0
		}

		return new Metric("completeness", "proportion of float and integer elements without units of measure",
				"propNoUnitOfMeasure", weight, score);
	}
}
