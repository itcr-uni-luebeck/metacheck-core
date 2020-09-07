package core.statistics;

import core.model.MyNamespace;

/**
 * class to compute the average number of data elements per data element group
 * of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class AverageNumberOfDataElementsPerGroup implements IStatistic {

	/**
	 * compute statistic average number of data elements per data element group
	 * 
	 * @param namespace of type MyNamespace
	 * @return computed statistic average number of data elements per group
	 */
	@Override
	public Statistic calculate(MyNamespace namespace) {
		float result = 0;
		float numOfDataelements = namespace.getMyDataElements().size();
		float numOfGroups = namespace.getMyDataElementGroup().size();
		if (numOfGroups != 0) {
			result = numOfDataelements / numOfGroups;
		} else {

		}

		return new Statistic("average number of dataelements per group", "elementsPerGroup", result);
	}
}
