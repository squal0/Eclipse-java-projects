/**
 * The following program demonstrates the difference between
 * passing an entire array and passing a primitive type array
 * element to a method.
 */
package arrays;

/**
 * @author Home
 *
 */
public class PassingArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] array = { 1, 2, 3, 4, 5};
		System.out.printf("Effects of passing references to entire array: %n" + "The values of the original array are:%n");
		for (int value: array) //output the original array elements
			System.out.printf("%n%d", value);
		
		modArray(array); //pass array reference
		System.out.printf("%nThe values of the modified array are: %n");
		for (int value : array) //output the modified array
			System.out.printf("%n%d", value);
		
		System.out.printf("%nEffects of passing array element value: %n" +
							"array[3] before modElement %d%n", array[3]);
		modElement(array[3]); //attempt to modify array[3]
		System.out.printf("array[3] after modElement %d%n", array[3]);
			
	}
	public static void modArray(int [] array2){ //multiply each element by 2
		for (int counter = 0; counter < array2.length; counter++)
			array2[counter] *= 2;
	}
	public static void modElement(int elem){ //multiply each argument by 2
		elem *= 2;
		System.out.printf("The value of element in modElement is: %d%n", elem);
	}
}
	
