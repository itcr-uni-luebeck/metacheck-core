package core.metric.dataelementmetrics;

import core.model.MyDataElement;

/**
 * class with method to check and evaluate if a dataelement`s definition value
 * length is greater than the length of its designation value
 * 
 * @author Alexandra Banach
 *
 */
public class CheckDefinitionDesignationValue implements IMetric {
	/**
	 * method to check and evaluate if a dataelement`s definition value length is
	 * greater than the length of its designation value
	 * 
	 * @param
	 * @return
	 */
	@Override
	public Score calculate(MyDataElement dataelement) {
		// initialize score
		Score score = new Score(0, 1);
		// if definition length is greater than designation length
		if (dataelement.getMyDesignations().get(0).getDefinition().length() > dataelement.getMyDesignations().get(0)
				.getDesignation().length()) {
			// change score to (1,1)
			score.setScore(1);
		}
		return score;
	}
}
