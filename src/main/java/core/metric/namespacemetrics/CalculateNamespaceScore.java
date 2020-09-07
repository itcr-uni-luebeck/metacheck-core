package core.metric.namespacemetrics;

import java.util.List;

/**
 * class to calculate the score of a namespace
 * 
 * @author Alexandra Banach
 *
 */
public class CalculateNamespaceScore {
	/**
	 * method to calculate the score of a namespace
	 * 
	 * @param list of all computed metrics of a namespace
	 * @return score of a namespace
	 */

	public float calculateScore(List<Metric> metrics) {
		// initialize
		float score = 0;
		float weight = 0;

		// sum all weights and metric scores
		for (Metric m : metrics) {
			weight += m.getWeight();
			score += m.getWeight() * m.getScore();
		}
		// compute namespace score and return
		float namespaceScore = 0;
		if (weight != 0) {
			namespaceScore = score / weight;
		} else {

		}
		return namespaceScore;
	}
}
