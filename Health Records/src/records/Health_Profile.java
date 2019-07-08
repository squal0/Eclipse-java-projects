/**
 * Class demonstrates a patient's health record. It includes the person's
 * details and also calculates the person's age, target heart rate and maximum heart rate. 
 */
package records;

import java.util.Calendar;
import java.util.Scanner;
/**
 * @author Home
 *
 */
public class Health_Profile {
	//instance variables
	private String firstName;
	private String otherNames;
	private char gender;
	private double height;
	private double weight;
	private int age;
	private int mHR;
	private double tHR;
	private static Scanner input;
	
	//constructor
	public Health_Profile(String firstName, String otherNames, char gender, double height
			, double weight, int age){
		this.setFirstName(firstName);
		this.setOtherNames(otherNames);
		this.setGender(gender);
		this.setWeight(weight);
		this.setHeight(height);
		this.setAge(age);
	}
	
	//getter and setter methods for the instance variables
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if( firstName != null && firstName.length() != 0){
			this.firstName = firstName;
		}
		else {
			System.out.println("First Name cannot be empty");
		}
		
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		if( otherNames != null && otherNames.length() != 0){
			this.otherNames = otherNames;
		}
		else {
			System.out.println("Other Names cannot be empty");
		}
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getAge() {
		input = new Scanner(System.in);
		System.out.println("\nPlease enter your Year of birth");
		int birthYear = input.nextInt();
		Calendar now = Calendar.getInstance();   // Gets the current date and time
		int currentYear = now.get(Calendar.YEAR);
		age = currentYear - birthYear;
		  return age;
	}

	public void setAge(int age) {
		this.age = age;
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
