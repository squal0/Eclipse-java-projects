/**
 * The following program illustrates the die rolling program 
 * using an array and random number generator
 */
package chanceGames;

/**
 * @author Home
 *
 */
import java.security.SecureRandom;
public class DieRoll_Array {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecureRandom randNums = new SecureRandom();
		int [] freq = new int[7]; //array of frequency counters
		for(int roll = 1; roll <= 6000000; roll++)
			++freq[1 + randNums.nextInt(6)];
			System.out.printf("%s%10s%n", "Face", "Frequency");
			
			for(int face = 1; face < freq.length; face++)
				System.out.printf("%4d%10d%n", face, freq[face]);
	}
}
