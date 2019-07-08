/**
 * Program that inputs 10 numbers and determines which is the largest.
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class Largest {

	/**
	 * @param args
	 */
	private static Scanner userInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in);
		int counter = 0;
		int num;
		int largest = 0;
		
		//loop to get the 10 inputs of numbers
		while( counter <= 10){
			System.out.println("Enter a number");
			num = userInput.nextInt();
			counter += 1;
			//determine the largest
			if( num > largest){
				largest = num;
			}
		}
		
		System.out.printf("%nLargest number is: %d%n", largest);
	}

}
