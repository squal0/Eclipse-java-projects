/**
 * Determines the factorial of a non negative number.
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class Factorial {

	/**
	 * @param args
	 */
	private static Scanner input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new Scanner(System.in);
		//variables
		int a, i;
		long fact = 1;
		System.out.println("Enter a number to calculate it's factorial:");
		i = input.nextInt();
		
		//validation
		if( i < 0){
			System.out.println("Number should be a non negative");
		}
		else {
		//for loop
		for( a = 1; a <= i ; a++)
			fact = fact * a;
		System.out.printf("%nThe Factorial of %d = %d%n", i, fact);
	}
	}

}
