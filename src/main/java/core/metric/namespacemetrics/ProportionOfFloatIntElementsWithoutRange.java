package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class to compute metric proportion of float and integer elements without
 * value range
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfFloatIntElementsWithoutRange implements IMetricNamespace {
	/**
	 * compute metric proportion of float and integer elements without value range
	 * 
	 * @param namespace
	 * @return computed metric proportion of float and integer elements without
	 *         value range
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// get all dataelements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfFloatInt = 0;
		int numberOfFloatIntWithoutRange = 0;

		// count number of all floats and integer elements and count number of elements
		// without range
		for (MyDataElement de : dataelements) {
			if ((de.getMyValidation().getDatatype().equals("INTEGER")
					&& de.getMyValidation().getValidationType().equals("INTEGER"))
					|| (de.getMyValidation().getDatatype().equals("FLOAT")
							&& de.getMyValidation().getValidationType().equals("FLOAT"))) {
				numberOfFloatInt++;
				numberOfFloatIntWithoutRange++;
			} else if ((de.getMyValidation().getDatatype().equals("FLOAT")
					&& de.getMyValidation().getValidationType().equals("FLOATRANGE"))
					|| (de.getMyValidation().getDatatype().equals("INTEGER")
							&& de.getMyValidation().getValidationType().equals("INTEGERRANGE"))) {
				numberOfFloatInt++;
			} else {

			}
		}

		// compute proportion and return it
		float weight = 0;
		float score = 0;
		if (numberOfFloatInt != 0) {
			// divide number of float and int elements with range by number of all float and
			// int elements
			weight = (float) numberOfFloatIntWithoutRange / dataelements.size();
		} else {
			// if there are not float and integer elements the result is 0
		}

		return new Metric("consistency", "proportion of float and integer elements without range",
				"propFloatIntWithoutRange", weight, score);
	}
}
