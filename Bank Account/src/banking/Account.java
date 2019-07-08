/**
 * class that contains the name instance variable and methods
 * to retrieve it.
 */
package banking;

/**
 * @author Squal0
 *
 */
public class Account {
	//instance variables
	private String name;
	private double balance;
	
	/**constructor initializes name with parameter name
	*when explicitly declaring a constructor the default one will not be created and hence
	*one cannot create new objects using the new Account()
	*/
	public Account(String name, double balance){ //account constructor that receives 2 parameters
		this.name = name; //assign name to instance variable name
		
		/**
		 * validate that the balance is greater than 0.0 if it's not,
		 * instance variable balance keeps its initial value of 0.0
		 */
		if ( balance > 0.0)
			this.balance = balance; //assign it to instance variable balance
	}
	
	//method that deposits (adds) only a valid amount to the balance
	public void deposit( double depositAmount){
		if ( depositAmount > 0.0) //if the depositAmount is valid
			balance += depositAmount; //add it to the balance
	}
	
	//method that withdraws(removes) only a valid amount to the balance
	public void withdraw( double withdrawAmount){
		if ( withdrawAmount < balance) //if the withdrawal amount is valid
			balance-= withdrawAmount; //remove it from the balance
		else
			System.out.println("Withdrawal amount exceeded current balance.");
	}
	
	//method that returns the account balance
	public double getBalance(){
		return balance;
	}
	
	//method to set the name in the object
	public void setName(String name){
		this.name = name; //store the name
	}
	//method to retrieve the name from the object
	public String getName(){
		return name; //return the value of name to the caller
	}

}
