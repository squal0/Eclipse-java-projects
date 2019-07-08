/**
 * The following class takes a person's details and uses them as variables,
 * to calculate a person's target heart rate and maximum heart rate.
 * This program is based on the heart rate calculator developed by the
 *  American Heart Association (AHA) 
 *  (www.americanheart.org/presenter.jhtml?identifier=4736).
 */
package heart_rates;

import java.util.Calendar;
import java.util.Scanner;
/**
 * @author squal0
 *
 */
public class HeartRates {
	//instance variables to be used with the program
	private String firstName;
	private String otherNames;
	private int age;
	private int mHR;
	private double tHR;
	private static Scanner input;
	
	//constructor that receives the data as parameters
	public HeartRates(String firstName, String otherNames, int age){
		this.setFirstName(firstName);
		this.setOtherNames(otherNames);
		this.setAge(age);
	}

	//getter and setter methods for the instance variables
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		//validation to ensure that firstName is not an empty string
		if( firstName != null && firstName.length()!= 0){
			this.firstName = firstName;
		}
		else{
			System.out.println("First Name cannot be empty");
		}
		
	}
	public String getOtherNames() {
		return otherNames;
	}
	public void setOtherNames(String otherNames) {
		//validation to ensure that otherNames is not an empty string
		if( otherNames != null && otherNames.length() != 0){
			this.otherNames = otherNames;
		}
		else{
			System.out.println("Other Names cannot be empty");
		}
	}
	
	public void setAge(int age) {
		this.age = age;	
	}
	
	//methods to calculate the current age using current time and birth date
	public int getAge() {
		input = new Scanner(System.in);
		System.out.println("\nPlease enter your Year of birth");
		int birthYear = input.nextInt();
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int currentYear = now.get(Calendar.YEAR);
		age = currentYear - birthYear;
		  return age;
	}
	
	//method to calculate the maximum heart rate of the person
	public int getMHR(){
		mHR = 220 - age;
		return mHR;
	}
	public double getTHR(){
		tHR = 0.5 * mHR;
		return tHR;
	}
}
