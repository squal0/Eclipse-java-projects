/**
 * The following program prints out elements of an array together
 * with the sum of all array elements
 */
package arrays;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class SumArrays {

	/**
	 * @param args
	 */
	private static Scanner userInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in);
		int [] array = new int[20];
		int sum = 0;
		double average = 0;
		int counter = 0;
		System.out.println("Enter values:");
		for(counter = 0; counter < array.length; counter++){
			array[counter] = userInput.nextInt();
		}
		System.out.printf("%s%8s%n", "Index", "Value");
		
		for (counter =0; counter < array.length; counter++){
			sum += array[counter];
			average = (double)sum / array.length;
			System.out.printf("%5d%8d%n", counter, array[counter]);
		}
		System.out.println("\n************************************");
		System.out.printf("%nSum of array elements is: %d%n", sum);
		System.out.printf("%nAverage of array elements is: %.2f%n", average);
	}

}
