package core.metric.reflections;

import java.lang.reflect.Method;

/**
 * class to model the object MethodwithClass which is needed as result of the
 * method getMethodsByNameFromPackage from the class ReflectionHelper an object
 * consists of a method and its class
 * 
 * @author Alexandra Banach
 *
 */
public class MethodWithClass {
	// name of the method
	private Method myMethod;
	// name of the method`s class
	private Class<?> myClass;

	/**
	 * constructor of an object MethodWithClass
	 * 
	 * @param myMethod as name of a method
	 * @param myClass  as name of a class
	 */
	public MethodWithClass(Method myMethod, Class<?> myClass) {
		this.myMethod = myMethod;
		this.myClass = myClass;
	}

	/**
	 * getter for the method of an object MethodWithClass
	 * 
	 * @return method of an object MethodWithClass
	 */
	public Method getMyMethod() {
		return myMethod;
	}

	/**
	 * setter for the method of an object MethodWithClass
	 * 
	 * @param myMethod as method to set at an object MethodWithClass
	 */
	public void setMyMethod(Method myMethod) {
		this.myMethod = myMethod;
	}

	/**
	 * getter for the class of an object MethodWithClass
	 * 
	 * @return class of an object MethodWithClass
	 */
	public Class<?> getMyClass() {
		return myClass;
	}

	/**
	 * setter for the class of an object MethodWithClass
	 * 
	 * @param myClass
	 */
	public void setMyClass(Class<?> myClass) {
		this.myClass = myClass;
	}

}
