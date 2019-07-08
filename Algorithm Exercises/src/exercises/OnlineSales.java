/**
 * Program uses user input to calculate the sales for products
 * of an online retailer.
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class OnlineSales {

	/**
	 * @param args
	 */
	private static Scanner userInput;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		userInput = new Scanner(System.in); //to read user input
		double prodPrice;
		int prodNo;
		double salesTotal;
		double sumSales = 0;
		//variables to count the no of products sold
		int prod1 = 0;
		int prod2 = 0;
		int prod3 = 0;
		int prod4 = 0;
		int prod5 = 0;
		int counter = 0;
		
		System.out.println("********************************************");
		while(counter != -1){
			System.out.println("Enter a Product number: Range between 1 - 5.");
			prodNo = userInput.nextInt();
			
			//use switch case to determine the price of the products
			switch(prodNo){
			case 1:
				prodPrice = 2.98;
				prod1++;
				salesTotal = prodPrice * prod1;
				System.out.printf("Sales for Product 1 are: %.2f%n", salesTotal);
				sumSales++;
				break;
			case 2:
				prodPrice = 4.50;
				prod2++;
				salesTotal = prodPrice * prod2;
				System.out.printf("Sales for Product 2 are: %.2f%n", salesTotal);
				sumSales++;
				break;
			case 3:
				prodPrice = 9.98;
				prod3++;
				salesTotal = prodPrice * prod3;
				System.out.printf("Sales for Product 3 are: %.2f%n", salesTotal);
				sumSales++;
				break;
			case 4:
				prodPrice = 4.49;
				prod4++;
				salesTotal = prodPrice * prod4;
				System.out.printf("Sales for Product 4 are: %.2f%n", salesTotal);
				sumSales++;
				break;
			case 5:
				prodPrice = 6.87;
				prod5++;
				salesTotal = prodPrice * prod5;
				System.out.printf("Sales for Product 5 are: %.2f%n", salesTotal);
				sumSales++;
				break;
			default:
				System.out.println("Sorry we dont sell a product with that Product Number.");
				break;
			}
		}
	}

}
