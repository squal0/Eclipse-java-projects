package examples;

/* Java class to illustrate the creation of class with instance variables,
 * parameterised and non-parameterised constructors. 
 */

public class Triangle {
	//triangle instance variables 
	protected int base;
	protected int height;
	protected float hypotenuse;
	protected float area;
	protected float perimeter;
	
	// create a default constructor to set fixed base and height
	Triangle(){
		System.out.println("Default constructor invoked/called");
		base = 20;
		height = 15;
	}
	
	//create a parameterised constructor i.e one that takes arguments
	Triangle(int bs, int ht){
		System.out.println("Parameterised constructor invoked/called");
		base = bs;
		height = ht;
	}
	protected float calcArea(){
		System.out.println("The area of the triangle is:");
		return (float) (0.5 * (base * height));
	}
	protected float calcHypotenuse(){
		System.out.println("The hypotenuse of the triangle is:");
		return hypotenuse = (float) Math.sqrt((Math.pow(base, 2)) + (Math.pow(height, 2)));
	}
	protected float calcPerimeter(){
		System.out.println("The perimeter of the triangle is:");
		return perimeter = base + height + hypotenuse;
	}

}
