package core.metric.exceptions;

/**
 * class to throw an exception if an invalid name for a namespaced is used to
 * get data
 * 
 * @author Alexandra Banach
 *
 */
public class InvalidNamespaceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructor for exception that should be thrown when an invalid name for a
	 * namespace is used to get data
	 */
	public InvalidNamespaceException(String message) {
		super(message);
	}
}
