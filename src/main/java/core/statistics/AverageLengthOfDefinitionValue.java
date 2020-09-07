package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method that calculates the average length of a dataelement`s
 * definition field of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class AverageLengthOfDefinitionValue implements IStatistic {
	/**
	 * method to calculate the average length of a dataelement`s definition value of
	 * a namespace
	 * 
	 * @param namespace of type MyNamespace
	 * @return average length of a dataelement`s definition field of a namespace as
	 *         Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// get all dataelements of namespace
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		// initialize variables to compute result
		int length = 0;
		int numberOfDefinitionFields = 0;

		// check all dataelements
		for (MyDataElement de : dataelements) {
			// get each definition field
			for (int i = 0; i < de.getMyDesignations().size(); i++) {
				// add length of all definition fields
				length += de.getMyDesignations().get(i).getDefinition().length();
				// count number of definition fields
				numberOfDefinitionFields++;
			}
		}

		// compute result and return it
		float result = 0;
		if (numberOfDefinitionFields != 0) {
			// divide summed lengths by number of fields
			result = (float) length / numberOfDefinitionFields;
		} else {
			// if there are no definition fields the result is 0
		}

		return new Statistic("average length of definition value", "averageDefValue", result);
	}
}
