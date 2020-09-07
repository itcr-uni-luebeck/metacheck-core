package core.metric.exceptions;

/**
 * class to throw an Exception if one parameter for 
 * calculation of metrics or comparison of namespaces
 * is missing e.g. URI of Samply.MDR, name of namespace or
 * language
 * @author Alexandra Banach
 *
 */
public class EmptyParametersException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * constructor for EmptyParametersException. It is thrown
	 * if one parameter for 
	 * calculation of metrics or comparison of namespaces
	 * is missing e.g. URI of Samply.MDR, name of namespace or
	 * language
	 * @param message
	 */
	public EmptyParametersException(String message) {
		super(message);
	}
}
