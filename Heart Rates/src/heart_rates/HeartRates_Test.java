/**
 * The following class calls methods from the HeartRates.java class
 * Asks the user for input and uses the input to calculate
 * the user's age, Maximum Heart Rate and Target Heart Rate
 */
package heart_rates;

import java.util.Scanner;
/**
 * @author Home
 *
 */

public class HeartRates_Test {

	/**
	 * @param args
	 */
	//create an object from the Scanner class
	private static Scanner userInput;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in);
		
		//create new objects of the class HeartRates
		HeartRates patient1 = new HeartRates(null, null, 0);
		
		//prompt and read the user input
		System.out.println("Please enter your First Name: ");
		String fName = userInput.nextLine();
		patient1.setFirstName(fName);
		System.out.println("Please enter your Other Names: ");
		String oNames = userInput.nextLine();
		patient1.setOtherNames(oNames);
		

		
		//display the all of the user's info plus their THR and MHR
		System.out.println("===================================");
		System.out.printf("%nNames: %17s %s.", patient1.getFirstName(), patient1.getOtherNames() );
		System.out.printf("%nAge: %17d years", patient1.getAge());
		System.out.printf("%nMaximum Heart Rate: %d beats/min", patient1.getMHR());
		System.out.printf("%nTarget Heart Rate: %.2f beats/min" , patient1.getTHR());
		System.out.println("\n===================================");
		
	}

}
