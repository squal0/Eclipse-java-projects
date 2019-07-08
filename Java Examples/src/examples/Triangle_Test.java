package examples;
/*
 * Java program to test the creation of  objects using default and
 * parameterised constructors
 */

import java.util.Scanner;

public class Triangle_Test {
	//declare a scanner so as to access the scanner class utilities
	protected static Scanner userInput;

	//main method to begin the execution of the program
	public static void main(String[] args) {
		//create a new scanner
		userInput = new Scanner(System.in);
		
		//create 2 Triangle objects
				Triangle triangle1, triangle2;
				//instantiate the first triangle using the default constructor
				triangle1 = new Triangle();
				//get the hypotenuse,area and perimeter of triangle 1
				triangle1.calcHypotenuse();
				triangle1.calcArea();
				triangle1.calcPerimeter();
				//declare variables to hold the triangle measurements to be inputed by the user
				int userBase, userHeight;
				//prompt the user for the base and the height of the second triangle
				System.out.println("Please enter the base of the triangle");
				//read in the values
				userBase = userInput.nextInt();
				System.out.println("Please enter the height of the triangle");
				userHeight  = userInput.nextInt();
				
				//instantiate the second triangle using the parameters from the user
				triangle2 = new Triangle(userBase, userHeight);
				//get the hypotenuse,area and perimeter of triangle 2
				triangle2.calcHypotenuse();
				triangle2.calcArea();
				triangle2.calcPerimeter();
				
				//display the dimensions of the two Triangles
				System.out.println("Dimensions of the Triangle");
				System.out.println("Triangle 1\'s Dimensions");
				System.out.println("========================>");
				System.out.println("Base: " + triangle1.base + "cm.");
				System.out.println("Height: " + triangle1.height + "cm.");
				System.out.println("Hypotenuse: " + triangle1.calcHypotenuse() + "cm.");
				System.out.println("Area: " + triangle1.calcArea() + "cm2.");
				System.out.println("Perimeter: " + triangle1.calcPerimeter() + "cm.");
				System.out.println("Triangle 2\'s Dimensions");
				System.out.println("=========================>");
				System.out.println("Base: " + triangle2.base + "cm.");
				System.out.println("Height: " + triangle2.height + "cm.\n");
				System.out.println("Hypotenuse: " + triangle2.calcHypotenuse() + "cm.");
				System.out.println("Area: " + triangle2.calcArea() + "cm2.");
				System.out.println("Perimeter: " + triangle2.calcPerimeter() + "cm.");

	}

}
