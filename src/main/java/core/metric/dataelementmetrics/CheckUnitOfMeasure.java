package core.metric.dataelementmetrics;

import core.model.MyDataElement;

/**
 * class with a method to check if a dataelement has a unit of measure
 * 
 * @author Alexandra Banach
 *
 */
public class CheckUnitOfMeasure implements IMetric {
	/**
	 * check if dataelement has a unit of measure: if yes score is (1,1), else (0,1)
	 * 
	 * @param myDataelement
	 * @return score of type integer for a dataelement and the maximum possible
	 *         score for this metric
	 */
	@Override
	public Score calculate(MyDataElement myDataelement) {
		// if dataelement has a unit of measure score is (1,1)
		if (myDataelement.getMyValidation().getUnitOfMeasure() != "null") {
			return new Score(1, 1);
		} else {
			return new Score(0, 1);
		}
	}
}
