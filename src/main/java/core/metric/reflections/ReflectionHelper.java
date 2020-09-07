package core.metric.reflections;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * class was found on the internet to get all classes of a package via Java
 * Reflection method getMethodByNameFromPackage was implemented and added
 * source:
 * https://github.com/viveksingh0143/bms/blob/master/src/ReflectionHelper.java
 * 
 * @author Alexandra Banach
 *
 */
public class ReflectionHelper {
	public static List<Class<?>> findClassesImpmenenting(final Class<?> interfaceClass, final Package fromPackage) {

		if (interfaceClass == null) {
			System.out.println("Unknown subclass.");
			return null;
		}

		if (fromPackage == null) {
			System.out.println("Unknown package.");
			return null;
		}

		final List<Class<?>> rVal = new ArrayList<Class<?>>();
		try {
			final Class<?>[] targets = getAllClassesFromPackage(fromPackage.getName());
			if (targets != null) {
				for (Class<?> aTarget : targets) {
					if (aTarget == null) {
						continue;
					} else if (aTarget.equals(interfaceClass)) {
						System.out.println("Found the interface definition.");
						continue;
					} else if (!interfaceClass.isAssignableFrom(aTarget)) {
						System.out.println("Class '" + aTarget.getName() + "' is not a " + interfaceClass.getName());
						continue;
					} else {
						rVal.add(aTarget);
					}
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Error reading package name.");
			e.printStackTrace();
			// Debug.printStackTrace(e, Debug.LOW_LEVEL);
		} catch (IOException e) {
			System.out.println("Error reading classes in package.");
			e.printStackTrace();
			// Debug.printStackTrace(e, Debug.LOW_LEVEL);
		}

		return rVal;
	}

	/**
	 * Load all classes from a package.
	 * 
	 * @param packageName
	 * @return
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@SuppressWarnings("rawtypes")
	public static Class[] getAllClassesFromPackage(final String packageName)
			throws ClassNotFoundException, IOException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		assert classLoader != null;
		String path = packageName.replace('.', '/');
		Enumeration<URL> resources = classLoader.getResources(path);
		List<File> dirs = new ArrayList<File>();
		while (resources.hasMoreElements()) {
			URL resource = resources.nextElement();
			dirs.add(new File(resource.getFile()));
		}
		ArrayList<Class> classes = new ArrayList<Class>();
		for (File directory : dirs) {
			classes.addAll(findClasses(directory, packageName));
		}
		return classes.toArray(new Class[classes.size()]);
	}

	/**
	 * Find file in package.
	 * 
	 * @param directory
	 * @param packageName
	 * @return
	 * @throws ClassNotFoundException
	 */
	public static List<Class<?>> findClasses(File directory, String packageName) throws ClassNotFoundException {
		List<Class<?>> classes = new ArrayList<Class<?>>();
		if (!directory.exists()) {
			return classes;
		}
		File[] files = directory.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				assert !file.getName().contains(".");
				classes.addAll(findClasses(file, packageName + "." + file.getName()));
			} else if (file.getName().endsWith(".class")) {
				classes.add(
						Class.forName(packageName + '.' + file.getName().substring(0, file.getName().length() - 6)));
			}
		}
		return classes;
	}

	/**
	 * method to get all methods with a specific name from a package
	 * 
	 * @param methodname name of method which should be found
	 * @param myPackage  name of package to do search
	 * @param skipMethod e.g. name of an interface whose method should not be
	 *                   returned
	 * @return list of type MethodWithClass contains all methods which were found
	 * @throws IOException            might appear while getting all classes of a
	 *                                package to find methods to compute metrics
	 * @throws ClassNotFoundException might appear while getting all classes of a
	 *                                package to find methods to compute metrics
	 */
	@SuppressWarnings("rawtypes")
	public static List<MethodWithClass> getMethodsByNameFromPackage(String methodname, String myPackage,
			String skipMethod) throws ClassNotFoundException, IOException {
		// put all calculate methods into that list later for calculating scores
		List<MethodWithClass> calculateMethods = new ArrayList<MethodWithClass>();

		// getting all calculate methods which are needed to calculate score for each
		// dataelement

		// get all classes from our package with metrics
		Class[] classes = ReflectionHelper.getAllClassesFromPackage(myPackage);
		// iterate through all classes
		for (Class cl : classes) {
			// skip interface, we do not want to call its method calculate
			if (cl.getName().equals(myPackage + "." + skipMethod)) {
				// look at all other classes
			} else {
				// get all methods for each class
				Method[] methods = cl.getDeclaredMethods();
				// for each method of a class
				for (Method m : methods) {
					// if it is a calculate method
					if (m.getName().equals(methodname)) {
						// add method to our collector list
						calculateMethods.add(new MethodWithClass(m, cl));

					}
				}

			}
		}

		return calculateMethods;
	}
}
