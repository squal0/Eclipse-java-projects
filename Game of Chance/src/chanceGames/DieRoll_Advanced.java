/**
 * The following program uses the Secure Random class to simulate the throw of a die
 * This program chooses a random number from the 6 faced die
 * produces the output of the 6 faced die after it has been rolled 6,000,000 times.
 */
package chanceGames;

/**
 * @author Home
 *
 */
import java.security.SecureRandom; //import the SecureRandom class
public class DieRoll_Advanced {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom randNums = new SecureRandom();
		
		//count the frequencies of the number of times a face appears
		int freq1 = 0;
		int freq2 = 0;
		int freq3 = 0;
		int freq4 = 0;
		int freq5 = 0;
		int freq6 = 0;
		
		//loop 6,000,000 times for the rolls of the die
		for(int roll = 1; roll <= 6000000; roll++){
			int face = 1 + randNums.nextInt(6); //pick a random integer
			
			switch(face){
			case 1:
				++freq1; //increment the 1's counter
				break;
			case 2:
				++freq2; //increment the 2's counter
				break;
			case 3:
				++freq3; //increment the 3's counter
				break;
			case 4:
				++freq4; //increment the 4's counter
				break;
			case 5:
				++freq5; //increment the 5's counter
				break;
			case 6:
				++freq6; //increment the 6's counter
				break;
			}
		}
		System.out.println("Face \t Frequency");
		System.out.printf("1\t %d%n2\t %d%n3\t %d%n4\t %d%n5\t %d%n6\t %d%n", freq1, freq2, freq3, freq4, freq5, freq6);
	}

}
