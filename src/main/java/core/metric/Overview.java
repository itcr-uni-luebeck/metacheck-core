package core.metric;

import java.util.List;

import core.metric.namespacemetrics.Metric;
import core.model.MyNamespace;
import core.statistics.Statistic;

/**
 * class to model object of type 
 * Overview as result of the computed
 * metrics of a namespace
 * @author Alexandra Banach
 *
 */
public class Overview {
	/**url of samply.mdr*/
	private String url;
	/**object of type namespace with all data from samply.mdr*/
	private MyNamespace namespace;
	/**if secured*/
	private boolean isSecured;
	/**list with all computed metrics and its names*/
	private List<Metric> metrics;
	
	private List<Statistic> statistics;
	
	private float namespaceScore;
	
	/**
	 * constructor for object of type Overview
	 * @param url
	 * @param namespace
	 * @param secured
	 * @param metrics
	 */
	public Overview(String url, MyNamespace namespace, boolean isSecured, List<Metric> metrics, List<Statistic> statistics, float namespaceScore) {
		this.url = url;
		this.namespace = namespace;
		this.isSecured = isSecured;
		this.metrics = metrics;
		this.statistics = statistics;
		this.setNamespaceScore(namespaceScore);
	}
	
	/**
	 * getter for url of samply.mdr
	 * @return url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * setter for url of samply.mdr
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * getter for object of type MyNamespace
	 * @return namespace
	 */
	public MyNamespace getNamespace() {
		return namespace;
	}
	
	/**
	 * setter for object of type MyNamespace
	 * @param namespace
	 */
	public void setNamespace(MyNamespace namespace) {
		this.namespace = namespace;
	}
	
	/**
	 * getter for isSecured
	 * @return secured
	 */
	public boolean isSecured() {
		return isSecured;
	}
	
	/**
	 * setter for isSecured
	 * @param isSecured
	 */
	public void setIsSecured(boolean isSecured) {
		this.isSecured = isSecured;
	}
	
	/**
	 * getter for list with computed metrics
	 * @return metrics: list with computed metrics
	 */
	public List<Metric> getMetrics() {
		return metrics;
	}
	
	/**
	 * setter for list with computed metrics
	 * @param metrics
	 */
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}

	/**
	 * getter for list with computed statistics
	 * @return list with computed statistics
	 */
	public List<Statistic> getStatistics() {
		return statistics;
	}

	/**
	 * setter for list with computed statistics
	 * @param statistics
	 */
	public void setStatistics(List<Statistic> statistics) {
		this.statistics = statistics;
	}

	/**
	 * getter for computed namespace score
	 * @return namespaceScore
	 */
	public float getNamespaceScore() {
		return namespaceScore;
	}

	/**
	 * setter for computed namespace score
	 * @param namespaceScore
	 */
	public void setNamespaceScore(float namespaceScore) {
		this.namespaceScore = namespaceScore;
	}
	
}
