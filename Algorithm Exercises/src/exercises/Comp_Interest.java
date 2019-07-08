/**
 * Program that calculates the compound interest based
 * on a particular rate. 
 */
package exercises;

/**
 * @author Home
 *
 */
public class Comp_Interest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//variables
		double principal = 1000.0; //initial amount before interest
		double rate; //interest rate
		int year; //year
		double amount; //amount on deposit at the end of each year
		
		System.out.printf("%s %20s%n", "Rate", "Amount on Deposit");
		
		//calculate the amount on deposit for given rates
		for(rate = 0.05 , year = 1; rate <= 0.1 && year <= 5;  ++year, rate += 0.01){
			//calculate the new amount based on the rate
			//rate /= 100;
			amount = principal * Math.pow(1.0 + rate, year);
			//display the rate and the year
			System.out.printf("%4.2f%, 20.2f%n", rate, amount );
		}
	}

}
