package defaultandstaticmethods;

//A simple Java program to demonstrate static
//methods in java
interface StaticMethodInInterface {
	// abstract method
	public void square(int a);

	// static method
	static void show() {
		System.out.println("Static Method Executed");
	}
}

public class StaticMethodInInterfaceDemo implements StaticMethodInInterface {
	// Implementation of square abstract method
	public void square(int a) {
		System.out.println(a * a);
	}

	public static void main(String args[]) {
		StaticMethodInInterfaceDemo d = new StaticMethodInInterfaceDemo();
		d.square(4);

		// Static method executed
		StaticMethodInInterface.show();
	}
}
