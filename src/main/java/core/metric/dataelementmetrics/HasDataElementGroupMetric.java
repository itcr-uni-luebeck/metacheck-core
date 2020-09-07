package core.metric.dataelementmetrics;

import core.model.MyDataElement;

/**
 * class with a method to check if a dataelement belongs to a group
 * 
 * @author Alexandra Banach
 *
 */
public class HasDataElementGroupMetric implements IMetric {
	/**
	 * check if dataelement has a group: if yes score is (1,1), else score is (0,1)
	 * 
	 * @param myDataelement to check
	 * @return score of type integer for a dataelement and the maximum possible
	 *         score for this metric
	 */
	@Override
	public Score calculate(MyDataElement myDataelement) {
		// if dataelement belongs to a group score is (1,1)
		if (myDataelement.hasDataElementGroup()) {
			return new Score(1, 1);
		} else {
			return new Score(0, 1);
		}
	}
}
