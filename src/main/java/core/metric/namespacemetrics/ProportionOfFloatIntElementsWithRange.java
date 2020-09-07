package core.metric.namespacemetrics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the proportion of float and integer
 * dataelements with a range of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class ProportionOfFloatIntElementsWithRange implements IMetricNamespace {
	/**
	 * method to calculate the proportion of float and integer dataelements with a
	 * range of a namespace: the proportion is calculated by dividing the number of
	 * elements of type int and float with a range by the number of all float and
	 * int elements
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed metric proportion of float and integer elements with range
	 */
	@Override
	public Metric calculate(MyNamespace namespace) {
		// get all dataelements and initialize variables
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		int numberOfFloatInt = 0;
		int numberOfFloatIntWithRange = 0;

		// count number of all floats and integer elements and count number of elements
		// with range
		for (MyDataElement de : dataelements) {
			if ((de.getMyValidation().getDatatype().equals("INTEGER")
					&& de.getMyValidation().getValidationType().equals("INTEGER"))
					|| (de.getMyValidation().getDatatype().equals("FLOAT")
							&& de.getMyValidation().getValidationType().equals("FLOAT"))) {
				numberOfFloatInt++;
			} else if ((de.getMyValidation().getDatatype().equals("FLOAT")
					&& de.getMyValidation().getValidationType().equals("FLOATRANGE"))
					|| (de.getMyValidation().getDatatype().equals("INTEGER")
							&& de.getMyValidation().getValidationType().equals("INTEGERRANGE"))) {
				numberOfFloatInt++;
				numberOfFloatIntWithRange++;
			} else {

			}
		}

		// compute proportion and return it
		float weight = 0;
		float score = 1;
		if (numberOfFloatInt != 0) {
			// divide number of float and int elements with range by number of all float and
			// int elements
			weight = (float) numberOfFloatIntWithRange / dataelements.size();
		} else {
			// if there are not float and integer elements the result is 0
		}

		return new Metric("consistency", "proportion of float and integer elements with range", "propFloatIntWithRange",
				weight, score);
	}
}
