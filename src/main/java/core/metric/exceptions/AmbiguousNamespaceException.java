package core.metric.exceptions;

/**
 * class to throw an exception when two namespaces have the same name and data
 * for them should be fetches
 * 
 * @author Alexandra Banach
 *
 */
public class AmbiguousNamespaceException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6893184605853202861L;

	/**
	 * contructor to throw an exception if data for namespaces that have the same
	 * name should be fetched
	 */
	public AmbiguousNamespaceException(String message) {
		super(message);
	}
}
