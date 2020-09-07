package core.metric.namespacemetrics;

/**
 * class to model a metric for metadata
 * 
 * @author Alexandra Banach
 *
 */
public class Metric {
	/** data quality category to which a metric belongs to */
	private String category;
	/** name of metric */
	private String metricName;
	/** short name of metric, used for HTML */
	private String metricShorthandSymbol;
	/** weight of metric to compute namespace score */
	private float weight;
	/** score of metric to compute namespace score */
	private float score;

	/**
	 * constructor of a metric
	 * 
	 * @param category:              category of data quality to which a metric
	 *                               belongs to
	 * @param metricName
	 * @param metricShorthandSymbol: short metric name, used for HTML
	 * @param weight                 of metric
	 * @param score                  of metric
	 */
	public Metric(String category, String metricName, String metricShorthandSymbol, float weight, float score) {
		this.setCategory(category);
		this.setMetricName(metricName);
		this.setMetricShorthandSymbol(metricShorthandSymbol);
		this.setWeight(weight);
		this.setScore(score);
	}

	/**
	 * getter for data quality category of a metric
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * setter for data quality category of a metric
	 * 
	 * @param category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * getter for metric name
	 * 
	 * @return metricName
	 */
	public String getMetricName() {
		return metricName;
	}

	/**
	 * setter for metric name
	 * 
	 * @param metricName
	 */
	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	/**
	 * getter for metricShorthandSymbolo
	 * 
	 * @return metricShorthandSymbol
	 */
	public String getMetricShorthandSymbol() {
		return metricShorthandSymbol;
	}

	/**
	 * setter for metricShorthandSymbol
	 * 
	 * @param metricShorthandSymbol
	 */
	public void setMetricShorthandSymbol(String metricShorthandSymbol) {
		this.metricShorthandSymbol = metricShorthandSymbol;
	}

	/**
	 * getter for weight of a metric
	 * 
	 * @return weight of a metric
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * setter for weight of a metric
	 * 
	 * @param weight
	 */
	public void setWeight(float weight) {
		this.weight = weight;
	}

	/**
	 * getter for score of a metric
	 * 
	 * @return score of a metric
	 */
	public float getScore() {
		return score;
	}

	/**
	 * setter for score of a metric
	 * 
	 * @param score
	 */
	public void setScore(float score) {
		this.score = score;
	}
}
