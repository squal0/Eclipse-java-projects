/**
 * Program finds the odd numbers for the range 1-5
 * It then calculates the product of the odd numbers.
 */
package exercises;

/**
 * @author Home
 *
 */
public class Odd_Products {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//variables
		int num = 1;
		int product = 1;
		
		for( num = 1; num <= 15; num++){
			if (num % 2 != 0){
				System.out.printf("The odd numbers are: %d%n", num);
			}
			product *= num;
		}
		System.out.printf("The product for the odd numbers is: %d", product);

	}

}
