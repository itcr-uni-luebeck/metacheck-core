package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to calculate the average length of a dataelement`s
 * designation field of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class AverageLengthOfDesignationValue implements IStatistic {

	/**
	 * method to calculate the average length of a dataelement`s designation value
	 * of a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return average length of a dataelement`s designation field of a namespace as
	 *         object of type Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all dataelements from namespace
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		// initialize variables to compute result
		int length = 0;
		int numberOfDesignationFields = 0;

		// check all dataelements
		for (MyDataElement de : dataelements) {
			// get all designation fields
			for (int i = 0; i < de.getMyDesignations().size(); i++) {
				// add length of all designation fields
				length += de.getMyDesignations().get(i).getDesignation().length();
				// count number of designation fields
				numberOfDesignationFields++;
			}
		}

		// compute result and return it
		float result = 0;
		if (numberOfDesignationFields != 0) {
			// divide summed lengths by number of fields
			result = (float) length / numberOfDesignationFields;
		} else {
			// if there are no designation fields the result is 0
		}

		return new Statistic("average length of designation value", "averageDesignValue", result);
	}
}
