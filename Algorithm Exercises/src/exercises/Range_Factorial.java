/**
 *Program calculates the factorial of a range of numbers 
 */
package exercises;

/**
 * @author Home
 *
 */
public class Range_Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		int num;
		long fact = 1;
		
		//for loop
		for(num = 1; num <= 20; num++){
			fact *= num;
			System.out.printf("The factorial of %d = %d%n", num, fact);
		}
		
	}

}
