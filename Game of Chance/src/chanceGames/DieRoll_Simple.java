/**
 * The following program uses the Secure Random class to simulate the throw of a die
 * This program chooses a random number from the 6 faced die
 * produces the output of the 6 faced die after it has been rolled 30 times.
 */
package chanceGames;

/**
 * @author Home
 *
 */
import java.security.SecureRandom; //import the SecureRandom class
public class DieRoll_Simple {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom randNums = new SecureRandom(); //creating an object from the SecureRandom class
		
		// loop 30 times
		for(int counter = 1; counter <= 30; counter++){
			//pick a random integer from 1 to 6
			int face = 1 + randNums.nextInt(6);
			//display the generated output
			System.out.printf("%d ", face);
			
			//if counter is divisible by 5 start a new line of output
			if (counter % 5 == 0)
				System.out.println();
			
		}
	}

}
