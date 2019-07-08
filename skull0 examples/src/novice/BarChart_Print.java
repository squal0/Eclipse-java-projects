/**
 *The following program prints a bar chart depending on the input of the user 
 */
package novice;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class BarChart_Print {

	/**
	 * @param args
	 */
	private static Scanner userInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in);
		int user;
		System.out.println("Please enter a number between 1 and 30:");
		for(int counter = 1; counter <= 5; counter++){
			user = userInput.nextInt();
			if (user > 30){
				System.out.println("Enter a number between 1 and 30:");
			}
			for(int starCounter = 1; starCounter <= user; starCounter++){
				System.out.print("*");
			}
		}
	}

}
