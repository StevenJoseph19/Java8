package defaultandstaticmethods;

interface MyInterface {
	/*
	 * This is a default method so we need not to implement this method in the
	 * implementation classes
	 */
	default void newMethod() {
		System.out.println("Newly added default method");
	}

	/*
	 * Already existing public and abstract method We must need to implement this
	 * method in implementation classes.
	 */
	void existingMethod(String str);
}

public class DefaultMethodInInterfaceDemo implements MyInterface {
	// implementing abstract method
	public void existingMethod(String str) {
		System.out.println("String is: " + str);
	}

	public static void main(String[] args) {
		DefaultMethodInInterfaceDemo obj = new DefaultMethodInInterfaceDemo();

		// calling the default method of interface
		obj.newMethod();
		// calling the abstract method of interface
		obj.existingMethod("Java 8 is easy to learn");

	}
}