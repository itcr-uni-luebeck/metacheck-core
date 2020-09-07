package core.metric.dataelementmetrics;

/**
 * class to model the Score as the result of a computed metric. It contains the
 * computed metric score of a dataelement and the maximum score which was
 * possible to achieve in this metric.
 * 
 * @author Alexandra Banach
 *
 */
public class Score {
	/** score which is computed for a dataelement */
	private int score;
	/** maximum score which was possible to achieve */
	private int maxScore;

	/**
	 * constructor for a Score as the result of a metric.
	 * 
	 * @param score    computed for a dataelement
	 * @param maxScore maximum possible score which can be achieved by a dataelement
	 */
	public Score(int score, int maxScore) {
		this.score = score;
		this.maxScore = maxScore;
	}

	/**
	 * getter for the computed score of a dataelement
	 * 
	 * @return score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * setter for the computed score of a dataelement
	 * 
	 * @param score
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * getter for the maximum score which was possible to achieve for a dataelement
	 * 
	 * @return maxScore
	 */
	public int getMaxScore() {
		return maxScore;
	}

	/**
	 * setter for the maximum score which was possible to achieve for a dataelement
	 * 
	 * @param maxScore
	 */
	public void setMaxScore(int maxScore) {
		this.maxScore = maxScore;
	}
}
