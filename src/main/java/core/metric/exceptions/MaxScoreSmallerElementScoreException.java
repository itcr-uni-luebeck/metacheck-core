package core.metric.exceptions;

/**
 * class to throw an exception when calculated score for a dataelement is
 * greater than the maximum possible score of an element
 * 
 * @author Alexandra Banach
 *
 */
public class MaxScoreSmallerElementScoreException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * method to throw an exception when calculated score for a dataelement is
	 * greater than the maximum possible score of an element
	 */
	public MaxScoreSmallerElementScoreException(String message) {
		super(message);
	}
}
