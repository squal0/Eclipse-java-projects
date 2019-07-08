/**
 * Driver class that call the Account's class methods
 */
package banking;

/**
 * @author Home
 *
 */
import java.util.Scanner; //import the scanner class
public class Account_Test {

	/**
	 * @param args
	 */
	private static Scanner userInput; //create a scanner object for user input
	
	public static void main(String[] args) {
		userInput  = new Scanner(System.in);
		
		//create a new object of the type account
		Account userAccount = new Account("Rayson Allie", 750000.00);
		Account userAccount1 = new Account("Jessica Jones", -4500.00);
		
		//display the initial value of the name
		System.out.printf("%s Initial name and balance are: $%.2f%n", userAccount.getName(), userAccount.getBalance());
		System.out.printf("%s Initial name and balance are: $%.2f%n", userAccount1.getName(), userAccount1.getBalance());
		
		//prompt for and read the deposit amount
		System.out.println("Please enter the deposit amount for userAccount");
		double myDeposit = userInput.nextDouble(); //local variable myDeposit
		System.out.printf("%n depositing $%.2f to userAccount balance %n%n", myDeposit);
		userAccount.deposit(myDeposit); // add to the balance of the userAccount
		
		//display the balances
		System.out.printf("%s balance: $%.2f%n%n", userAccount.getName(), userAccount.getBalance());
		System.out.printf("%s balance: $%.2f%n%n", userAccount1.getName(), userAccount1.getBalance());
		
		//prompt for and read the deposit amount
		System.out.println("Please enter the deposit amount for userAccount1");
		myDeposit = userInput.nextDouble();
		System.out.printf("%ndepositing $%.2f to userAccount1 balance %n%n", myDeposit);
		userAccount1.deposit(myDeposit); // add to the balance of the userAccount
		
		//display the balances
		System.out.printf("%s balance: $%.2f%n%n", userAccount.getName(), userAccount.getBalance());
		System.out.printf("%s balance: $%.2f%n%n", userAccount1.getName(), userAccount1.getBalance());
		
		//prompt for and read the withdrawal amount
		System.out.println("Please enter the withdrawal amount for userAccount");
		double myWithdraw = userInput.nextDouble(); //local variable myWithdraw
		System.out.printf("%nwithdrawing $%.2f to userAccount balance %n%n", myWithdraw);
		userAccount.withdraw(myWithdraw);
		
		//display the balances
		System.out.printf("%s balance: $%.2f%n%n", userAccount.getName(), userAccount.getBalance());
		System.out.printf("%s balance: $%.2f%n%n", userAccount1.getName(), userAccount1.getBalance());
		
		//prompt for and read the withdrawal amount
		System.out.println("Please enter the withdrawal amount for userAccount");
	    myWithdraw = userInput.nextDouble(); //local variable myWithdraw
		System.out.printf("%nwithdrawing $%.2f to userAccount balance %n%n", myWithdraw);
		userAccount1.withdraw(myWithdraw);
		
		//display the name and balance stored in the userAccount object
		System.out.printf("%s balance: $%.2f%n%n", userAccount.getName(), userAccount.getBalance());
		System.out.printf("%s balance: $%.2f%n%n", userAccount1.getName(), userAccount1.getBalance());
		
	}

}
