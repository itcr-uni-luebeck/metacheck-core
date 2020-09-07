package core.metric.dataelementmetrics;

import core.model.MyDataElement;

/**
 * class with a method to check and evaluate the datatype of a dataelement
 * 
 * @author Alexandra Banach
 *
 */
public class CheckDataType implements IMetric {

	/**
	 * check data type of a dataelement and return a score depending on its type
	 * 
	 * @param myDataelement
	 * @return score of type integer for a dataelement and the maximum possible
	 *         score for this metric
	 */
	@Override
	public Score calculate(MyDataElement myDataelement) {
		// if there is no datatype return score 0
		if (myDataelement.getMyValidation().getDatatype() == null) {
			return new Score(0, 2);
		} else {
			// if there is a datatype check it
			// return score 1 for dataelements of type integer, float, date, datetime, time
			// and boolean
			if ((myDataelement.getMyValidation().getDatatype().equals("INTEGER")
					&& myDataelement.getMyValidation().getValidationType().equals("INTEGER"))
					|| (myDataelement.getMyValidation().getDatatype().equals("FLOAT")
							&& myDataelement.getMyValidation().getValidationType().equals("FLOAT"))
					|| myDataelement.getMyValidation().getDatatype().equals("DATE")
					|| myDataelement.getMyValidation().getDatatype().equals("DATETIME")
					|| myDataelement.getMyValidation().getDatatype().equals("TIME")
					|| myDataelement.getMyValidation().getDatatype().equals("BOOLEAN")) {
				return new Score(1, 2);
				// return score 2: enumerations, String with REGEX, FLOATRANGE, INTEGERRANGE
			} else if (myDataelement.getMyValidation().getDatatype().equals("enumerated")
					|| (myDataelement.getMyValidation().getDatatype().equals("STRING")
							&& myDataelement.getMyValidation().getValidationType().equals("REGEX"))
					|| (myDataelement.getMyValidation().getDatatype().equals("FLOAT")
							&& myDataelement.getMyValidation().getValidationType().equals("FLOATRANGE"))
					|| (myDataelement.getMyValidation().getDatatype().equals("INTEGER")
							&& myDataelement.getMyValidation().getValidationType().equals("INTEGERRANGE"))) {
				return new Score(2, 2);
			} else {
				// return score 0 for dataelements of other types e.g. String
				return new Score(0, 2);
			}
		}
	}
}
