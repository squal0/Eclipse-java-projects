/**
 * The following program simulates using arrays to survey data
 */
package arrays;

/**
 * @author Home
 *
 */
public class SurveyArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] response = { 1, 2, 5, 4, 3, 5, 2, 1, 3, 3, 1, 4, 3, 3, 3,
							2, 3, 3, 2, 14 };
		int [] freq = new int[6];
		for(int ans = 0; ans < response.length; ans++){
			try{
				++freq[response[ans]];
			}
			catch(ArrayIndexOutOfBoundsException e){
				System.out.println(e);
				System.out.printf("response[%d]: %d%n%n", ans, response[ans]);
			}
		}
		System.out.printf("%s%10s%n", "Rating", "Frequency");
		for(int rating = 1; rating < freq.length; rating++)
			System.out.printf("%6d%10d%n", rating, freq[rating]);
	}

}
