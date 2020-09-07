package core.statistics;

/**
 * class to model object of type Statistic
 * 
 * @author Alexandra Banach
 *
 */
public class Statistic {
	/** name of statistic */
	private String statisticName;
	/** shorthand symbol of statistic, used for HTML */
	private String statisticShorthandSymbol;
	/** computed statistic value */
	private float statisticValue;

	/**
	 * constructor for object of type Statistic
	 * 
	 * @param statisticName
	 * @param statisticShorthandSymbol
	 * @param statisticValue
	 */
	public Statistic(String statisticName, String statisticShorthandSymbol, float statisticValue) {
		this.statisticName = statisticName;
		this.statisticShorthandSymbol = statisticShorthandSymbol;
		this.statisticValue = statisticValue;
	}

	/**
	 * getter for name of statistic
	 * 
	 * @return statisticName
	 */
	public String getStatisticName() {
		return statisticName;
	}

	/**
	 * setter for name of statistic
	 * 
	 * @param statisticName
	 */
	public void setStatisticName(String statisticName) {
		this.statisticName = statisticName;
	}

	/**
	 * getter for shorthand symbol of statistic
	 * 
	 * @return statisticShorthandSymbol
	 */
	public String getStatisticShorthandSymbol() {
		return statisticShorthandSymbol;
	}

	/**
	 * setter for shorthand symbol of statistic
	 * 
	 * @param statisticShorthandSymbol
	 */
	public void setStatisticShorthandSymbol(String statisticShorthandSymbol) {
		this.statisticShorthandSymbol = statisticShorthandSymbol;
	}

	/**
	 * getter for computed value of statistic
	 * 
	 * @return statisticValue
	 */
	public float getStatisticValue() {
		return statisticValue;
	}

	/**
	 * setter for computed value of statistic
	 * 
	 * @param statisticValue
	 */
	public void setStatisticValue(float statisticValue) {
		this.statisticValue = statisticValue;
	}
}
