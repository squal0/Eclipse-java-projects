/**
 * Driver class that calls methods from the invoice class
 */
package hardware_invoice;

/**
 * @author Home
 *
 */
import java.util.Scanner; //imports the package that contains the Scanner class
public class Invoice_Test {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create a scanner object for userInput
	
	public static void main(String[] args) {
		//initialize the scanner object
		userInput = new Scanner(System.in);
		
		//create an object of the type Invoice
		Invoice item1 = new Invoice("200", "ARRI Generator.", 12, 24599.99);
		
		//display the initial values of the of the item
		System.out.printf("Part_No: %s,%nPart_Description: %s%nInital values are:%nQuantity: %d,%nPrice:$%.2f.%n%n", item1.getPart_No(),item1.getPart_Description(),item1.getQuantity(),item1.getPrice());
		System.out.printf("The invoice amount is: $%.2f.%n%n", item1.getInvoiceAmount(item1.getPrice(), item1.getQuantity()));
		
		//prompt for and read in for the new values
		System.out.println("Please enter the price for the item:");
		double myPrice = userInput.nextDouble(); //local variable myPrice
		System.out.printf("The new price is: $%.2f%n", myPrice);
		System.out.println("Please enter the quantity:");
		int myQuantity = userInput.nextInt(); // local variable myQuantity
		System.out.printf("The new quantity is: %d", myQuantity);
		
		// calculate the Invoice amount
		System.out.printf("Part_No: %s,%nPart_Description: %s%nCurrent values are:",item1.getPart_No(),item1.getPart_Description());
		System.out.printf("%nQuantity: %d,%nPrice: $%.2f%n",myQuantity, myPrice);
		System.out.printf("%nThe new Invoice amount is: $%.2f%n%n",item1.getInvoiceAmount(myPrice,myQuantity));
	}

}
