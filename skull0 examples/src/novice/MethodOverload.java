/**
 *Program demonstrates the overloading of methods 
 */
package novice;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class MethodOverload {

	/**
	 * @param args
	 */
	private static Scanner userInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in);
		System.out.println("Please enter a number to calculate its square:");
		int num = userInput.nextInt();
		System.out.println("Please enter a number to calculate its square:");
		double num1 = userInput.nextDouble();
		System.out.println("\n==============================================");
		System.out.printf("The square of int num is: %d%n ", square(num));
		System.out.printf("The square of double num1 is: %.2f%n ", square(num1));
		System.out.println("==============================================");
	}
	//method that gets the square of double values
	public static double square(double dVal) {
		return dVal * dVal;
	}
	//method that gets the square of integer values
	private static int square(int iVal) {
		return iVal * iVal;
	}

}
