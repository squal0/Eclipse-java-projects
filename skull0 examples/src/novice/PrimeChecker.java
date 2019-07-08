/**
 * 
 */
package novice;

/**
 * @author Home
 *
 */
public class PrimeChecker {
	private int number;
	
	public PrimeChecker(int number){
		this.number = number;
	}
	public boolean is_prime(){
		if(this.number < 2){
			return false;
		}
		else if(this.number == 2){
			return true;
		}
		for(int num = 2; num < this.number; num++){
			if (this.number % num == 0){
				return false;
			}
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrimeChecker prime = new PrimeChecker(5);
		System.out.print(prime.is_prime());

	}

}
