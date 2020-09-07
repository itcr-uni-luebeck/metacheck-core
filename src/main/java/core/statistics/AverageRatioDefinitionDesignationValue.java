package core.statistics;

import java.util.List;

import core.model.MyDataElement;
import core.model.MyNamespace;

/**
 * class with method to compute ratio of average length of definition and
 * designation value of a namespace`s dataelements
 * 
 * @author Alexandra Banach
 *
 */
public class AverageRatioDefinitionDesignationValue implements IStatistic {
	/**
	 * method to compute ratio of average length of definition and designation value
	 * of a namespace`s dataelements
	 * 
	 * @param namespace of type MyNamespace
	 * @return ratio of average definition and designation value as object of type
	 *         Statistic
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		// initialize
		List<MyDataElement> dataelements = namespace.getMyDataElements();
		float designationLength = 0;
		float definitionLength = 0;
		float averageDefDes = 0;
		int counter = 0;

		// check all data elements
		for (MyDataElement e : dataelements) {
			for (int i = 0; i < e.getMyDesignations().size(); i++) {
				// add length of all definition/ designation fields
				definitionLength = e.getMyDesignations().get(i).getDefinition().length();
				designationLength = e.getMyDesignations().get(i).getDesignation().length();
				// add all ratios of definition and designation length
				averageDefDes += definitionLength / designationLength;
				counter++;
			}
		}

		// compute result as average of ratio and return it
		float result = averageDefDes / counter;
		return new Statistic("ratio of average definition and designation value", "ratioDefDesValue", result);
	}
}
