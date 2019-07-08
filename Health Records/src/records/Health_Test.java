/**
 * Driver class that calls methods from Health_Profile class.
 * uses them to display a patient's health record.
 */
package records;

import java.io.IOException;
import java.util.Scanner;
/**
 * @author Home
 *
 */
public class Health_Test {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create Scanner object
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		userInput  = new Scanner(System.in);
		//create objects from the class Health_Profile
		Health_Profile patient1 = new Health_Profile(null, null, (char) 0, 0, 0, 0);
		
		//prompt user for input
		System.out.println("Please enter your First Name: ");
		String fName = userInput.nextLine();
		patient1.setFirstName(fName);
		System.out.println("Please enter your Other Names: ");
		String oNames = userInput.nextLine();
		patient1.setOtherNames(oNames);
		System.out.println("Please enter your gender: ");
		char gend = (char) System.in.read();
		patient1.setGender(gend);
		System.out.println("Please enter your height in Inches:");
		double hgt = userInput.nextDouble();
		patient1.setHeight(hgt);
		System.out.println("Please enter your weight in Pounds: ");
		double wgt = userInput.nextDouble();
		patient1.setWeight(wgt);
		
		//print the output
		System.out.println("===================================");
		System.out.printf("%nNames: %s %s.", patient1.getFirstName(), patient1.getOtherNames() );
		System.out.printf("%nGender: %c", patient1.getGender());
		System.out.printf("%nAge: %d years.", patient1.getAge());
		System.out.printf("%nHeight: %.2f Inches.", patient1.getHeight());
		System.out.printf("%nWeight: %.2f Pounds.", patient1.getWeight());
		System.out.printf("%nMaximum Heart Rate: %d beats/min.", patient1.getMHR());
		System.out.printf("%nTarget Heart Rate: %.2f beats/min." , patient1.getTHR());
		System.out.println("\n===================================");
	}

}
