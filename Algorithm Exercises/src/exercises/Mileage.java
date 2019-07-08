/**
 * Following program determines the mileage of a number of automobiles
 * It prompts the user to enter values for miles and gallons,
 * and then calculates the mileage of the vehicles from the user input
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class Mileage {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create an object from the scanner class
	
	public static void main(String[] args) {
		// initialize the scanner object
		userInput = new Scanner(System.in);
		
		//declare and initialize the variables to be used
		double totalMiles = 0;
		int totalGallons = 0;
		int counter = 0;
		
		//prompt the user for miles
		System.out.println("Please enter the miles driven or 0 to exit:");
		double miles = userInput.nextDouble();
		//prompt the user for gallons
		System.out.println("Please enter the gallons used for the drive:");
		int gallons = userInput.nextInt();
		
		//while the user hasn't entered the sentinel value
		while ( miles != 0){
			double mpg  = miles / gallons;
			System.out.printf("The Mileage for the trip is: %.2f miles/gallon%n", mpg);
			
			//increment total miles to current value of miles
			totalMiles += miles;
			totalGallons += gallons;
			counter += 1;
			
			//prompt the user for miles
			System.out.println("Please enter the miles driven or 0 to exit:");
			miles = userInput.nextDouble();
			//prompt the user for gallons
			System.out.println("Please enter the gallons used for the drive:");
			gallons = userInput.nextInt();
			
		}
		double totalMPG = totalMiles / totalGallons;
		if (counter != 0)
			System.out.printf("The total mileage is: %.2f miles/gallon", totalMPG);
		
	}
}
