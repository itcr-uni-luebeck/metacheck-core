package core.metric.exceptions;

/**
 * class to throw an exception when trying to divide by 0 while computing the
 * score of a dataelement
 * 
 * @author Alexandra Banach
 *
 */
public class DivisionByZeroException extends Exception {
	/**
	 * 
	 */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor for DivisionByZeroException it is thrown when trying to divide by
	 * 0 while computing the score of a dataelement
	 */
	public DivisionByZeroException(String message) {
		super(message);
	}
}
