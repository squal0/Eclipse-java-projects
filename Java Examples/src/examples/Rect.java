package examples;

/* Java class to illustrate the creation of class with instance variables,
 * parameterised and non-parameterised constructors. 
 */
public class Rect
{
	//the rectangle's instance variables
	protected short length;
	protected short width;
	protected float area;
	protected float perimeter;
	
	// create a default constructor to set fixed length and width
	Rect(){
		System.out.println("Default constructor invoked/called");
		length = 12;
		width  = 8;
	}
	
	//create a parameterised constructor i.e one that takes arguments
	Rect(short len, short wid){
		System.out.println("Parameterised constructor invoked/called");
		length = len;
		width = wid;
	}
	
	//method for calculating the area of a rectangle
	protected float calcArea(){
		System.out.println("The area of the rectangle is:");
		return area = length * width;
	}
	
	//method for calculating the perimeter of a rectangle
	protected float calcPerimeter(){
		System.out.println("The perimeter of the rectangle is:");
		return perimeter = 2 * (length + width);
	}
	
	
}
