/**
 * Program that inputs 10 numbers and determines which is the smallest
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner; //import the scanner class
public class Smallest {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create an object from the scanner class
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in); //instantiate the object
		
		//variables
		int num;
		int smallest = Integer.MAX_VALUE;
		int counter = 0;
		
		//while loop to iterate through 10 inputs
		while (counter <= 10){
			System.out.println("Enter a number");
			num = userInput.nextInt();
			counter += 1;
			
			if (num < smallest){
				smallest = num;
			}
		}
		System.out.printf("The smallest number is: %d%n", smallest);
	}

}
