package core.metric;

/**
 * class to model the comparison of two
 * namespaces of Samply.MDR. For each Namespace
 * all datas are fetched. Then all metrics are 
 * calculated and the Overviews for both namespaces
 * are returned as Object Comparison
 * @author Alexandra Banach
 *
 */
public class Comparison {
	/**result of computed metrics of first namespace*/
	private Overview overviewNamespace1;
	/**result of computed metrics of second namespace*/
	private Overview overviewNamespace2;
	
	/**
	 * constructor for object of type Comparison as result of
	 * comparison of two namespaces from Samply.MDR. An object
	 * of type Comparison consists of both computed Overviews.
	 * @param overviewNamespace1 result of metrics calculation of first namespace
	 * @param overviewNamespace2 result of metrics calculation of second namespace
	 */
	public Comparison(Overview overviewNamespace1, Overview overviewNamespace2) {
		this.overviewNamespace1 = overviewNamespace1;
		this.overviewNamespace2 = overviewNamespace2;
	}
	
	/**
	 * getter for Overview of first namespace
	 * @return Overview of first namespace
	 */
	public Overview getOverviewNamespace1() {
		return overviewNamespace1;
	}
	
	/**
	 * setter for computed Overview of first namespace
	 * @param overviewNamespace1
	 */
	public void setOverviewNamespace1(Overview overviewNamespace1) {
		this.overviewNamespace1 = overviewNamespace1;
	}
	
	/**
	 * getter for Overview of second namespace
	 * @return Overview of second namespace
	 */
	public Overview getOverviewNamespace2() {
		return overviewNamespace2;
	}
	
	/**
	 * setter for computed Overview of second namespace
	 * @param overviewNamespace2
	 */
	public void setOverviewNamespace2(Overview overviewNamespace2) {
		this.overviewNamespace2 = overviewNamespace2;
	}
	
}
