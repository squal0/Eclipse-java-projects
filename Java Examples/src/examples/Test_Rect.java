package examples;

/*
 * Java program to test the creation of  objects using default and
 * parameterised constructors
 */
import java.util.Scanner;

public class Test_Rect
{
	
	protected static Scanner userInput;
	public static void main(String[] args)
	{
		//instantiate the userInput object
		userInput  = new Scanner(System.in);
		
		//create 2 Rect objects
		Rect rectangle1, rectangle2;
		//instantiate the first rectangle using the default constructor
		rectangle1 = new Rect();
		//get the area and perimeter of rectangle 1
		rectangle1.calcArea();
		rectangle1.calcPerimeter();
		//declare variables to hold the rectangle measurements to be inputed by the user
		short userLen, userWid;
		//prompt the user for the length and the width of the second rectangle
		System.out.println("Please enter the length of the rectangle");
		//read in the values
		userLen = userInput.nextShort();
		System.out.println("Please enter the width of the rectangle");
		userWid  = userInput.nextShort();
		
		//instantiate the second rectangle using the parameters from the user
		rectangle2 = new Rect(userLen, userWid);
		//get the area and the perimeter of rectangle 2
		rectangle2.calcArea();
		rectangle2.calcPerimeter();
		
		//display the dimensions of the two rectangles
		System.out.println("Dimensions of the rectangle");
		System.out.println("Rectangle 1\'s Dimensions");
		System.out.println("========================>");
		System.out.println("Length: " + rectangle1.length + "cm.");
		System.out.println("Width: " + rectangle1.width + "cm.");
		System.out.println("Area: " + rectangle1.calcArea() + "cm2.");
		System.out.println("Perimeter: " + rectangle1.calcPerimeter() + "cm.");
		System.out.println("Rectangle 2\'s Dimensions");
		System.out.println("=========================>");
		System.out.println("Length: " + rectangle2.length + "cm.");
		System.out.println("Width: " + rectangle2.width + "cm.\n");
		System.out.println("Area: " + rectangle2.calcArea() + "cm2.");
		System.out.println("Perimeter: " + rectangle2.calcPerimeter() + "cm.");
		
		
	}

}
