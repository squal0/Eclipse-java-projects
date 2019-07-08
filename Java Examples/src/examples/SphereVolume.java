/**
 * Class that prompts the user to enter the radius of a sphere
 * A method is then declared to calculate the volume of the sphere
 * Using the value given by the user
 */
package examples;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class SphereVolume {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create an object from the class Scanner
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in);
		double radius = 0;
		sphereVolume(radius);
	}
	//Method to calculate the volume of a sphere
	public static double sphereVolume(double rad) {
		//prompt the user to enter a value
		System.out.println("Please enter the radius of the given Sphere: ");
		double radius = userInput.nextDouble();
		double volume = (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
		System.out.println("===========================================");
		System.out.printf("The radius of the sphere is: %.2fcm%n", radius);
		System.out.printf("The volume of the sphere is: %.2fcm2", volume);
		System.out.println("\n=========================================");
		return volume;
	}

}
