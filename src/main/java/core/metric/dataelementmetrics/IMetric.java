
package core.metric.dataelementmetrics;

import core.model.MyDataElement;

/**
 * interface for all methods that calculate
 * metrics of a dataelement
 * @author Alexandra Banach
 *
 */
public interface IMetric {
	/**
	 * method to calculate metric score
	 * of a dataelement
	 * @param dataElement
	 * @return calculated score
	 */
	Score calculate(MyDataElement dataElement);
	
}
