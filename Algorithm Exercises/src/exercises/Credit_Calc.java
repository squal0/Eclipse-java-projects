/**
 *program prompts the user for input which is then used to calculate the new balance
 *The program also checks whether the customer has exceeded their own credit limit. 
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class Credit_Calc {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create an object from the scanner class
	
	public static void main(String[] args) {
		//initialize the scanner object
		userInput = new Scanner(System.in);
		//counter variable
		int counter = 0;
		int newBalance = 0;
		
		//prompt the user for input
		System.out.println("Enter your Account Number:");
		int accNo = userInput.nextInt();
		System.out.println("Enter the balance at the beginning of the month:");
		int balance  = userInput.nextInt();
		System.out.println("Enter the total of all items charged by the customer this month:");
		int totalCharges = userInput.nextInt();
		System.out.println("Enter the total of all credits applied to the customer’s account this month:");
		int totalCredit = userInput.nextInt();
		System.out.println("Enter the allowed credit limit:");
		int creditLimit  = userInput.nextInt();
		
		//using while loop to iterate through a number of users
		while ( balance != -1){
			newBalance = balance + totalCharges - totalCredit;
			if( newBalance > creditLimit){
				System.out.println("*****************************");
				System.out.printf("%nAccount Number: %d", accNo);
				System.out.printf("%nBalance : %d", balance);
				System.out.printf("%nCredit Limit: %d", creditLimit);
				System.out.printf("%nNew Balance: %d", newBalance);
				System.out.println("Credit limit exceeded");
				System.out.println("=============================");
			}
			else{
				System.out.println("*****************************");
				System.out.printf("%nAccount Number: %d", accNo);
				System.out.printf("%nBalance : %d", balance);
				System.out.printf("%nCredit Limit: %d", creditLimit);
				System.out.printf("%nNew Balance: %d%n", newBalance);
				System.out.println("=============================");
			}
			counter += 1;
			//prompt the user for input
			System.out.println("Enter your Account Number:");
			accNo = userInput.nextInt();
			System.out.println("Enter the balance at the beginning of the month:");
			balance  = userInput.nextInt();
			System.out.println("Enter the total of all items charged by the customer this month:");
			totalCharges = userInput.nextInt();
			System.out.println("Enter the total of all credits applied to the customer’s account this month:");
			totalCredit = userInput.nextInt();
			System.out.println("Enter the allowed credit limit:");
			creditLimit  = userInput.nextInt();
			
		}
		if ( counter !=0){

				System.out.println("*****************************");
				System.out.printf("%nAccount Number: %d", accNo);
				System.out.printf("%nBalance : %d", balance);
				System.out.printf("%nCredit Limit: %d", creditLimit);
				System.out.printf("%nNew Balance: %d%n", newBalance);
				System.out.println("=============================");
			}
		}

	}


