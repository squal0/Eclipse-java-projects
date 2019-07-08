/**
 * 
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class Commission_Calc {

	/**
	 * @param args
	 */
	private static Scanner userInput; //scanner object
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//create new scanner object
		userInput = new Scanner(System.in);
		//variables used
		final int earnings = 200;
		double grossSales;
		double commission;
		double tEarnings;
		int item1 = 0;
		int item2 = 0;
		int item3 = 0;
		int item4 = 0;
		int itemCounter = 1;
		
		//while loop to count the items
		while ( itemCounter <= 4){
			System.out.println("Enter number of item1's sold");
			item1 = userInput.nextInt();
			System.out.println("Enter number of item2's sold");
			item2 = userInput.nextInt();
			System.out.println("Enter number of item3's sold");
			item3 = userInput.nextInt();
			System.out.println("Enter number of item4's sold");
			item4 = userInput.nextInt();
			
			//increment the itemCounter
			itemCounter += 1;
		}
		grossSales = (item1 * 239.99) + ( item2 * 129.75) + (item3 * 99.95)
				+ (item4 * 350.89);
		commission = 0.09 * grossSales;
		tEarnings = earnings + commission;
		
		//print the values
		System.out.println("=========================================");
		System.out.printf("%nGross Sales: $%.2f", grossSales);
		System.out.printf("%nCommission: $%.2f", commission);
		System.out.printf("%nTotal Earnings: $%.2f%n", tEarnings);
		System.out.println("=========================================");

	}

}
