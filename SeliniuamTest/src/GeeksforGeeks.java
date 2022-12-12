// Java Program to Illustrate Concept of Constructors
// in Abstract Class

// Class 1
// Helper Abstract class
// Parent class
abstract class Content {

	int a;

	// Constructor of abstract class
	public Content(int a)
	{

		// This keyword refers to current instance itself
		this.a = a;
	}

	// Abstract method of abstract class
	abstract int multiply(int val);
}

// Class 2
// Helper class extending above Class1
// Child class of Abstract class
class GFG extends Content {

	// Constructor of Child class GFG
	GFG()
	{

		// Super keyword refers to parent class
		super(2);
	}

	// Defining method the abstract method
	public int multiply(int val)
	{

		// Returning value of same instance
		return this.a * val;
	}
}

// Class 3
// Main class
public class GeeksforGeeks {

	// Main driver method
	public static void main(String args[])
	{

		//Content c = new Content();
		// Creating reference object of abstract class
		// using it child class
		Content c = new GFG();

		// Calling abstract method of abstract class
		System.out.println(c.multiply(3));
	}
}
