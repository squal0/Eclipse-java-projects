/**
 * 
 */
package exercises;

/**
 * @author Home
 *
 */
public class Mystery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count = 1;
		while (count <= 10)
		{
	    System.out.println(count % 2 == 1 ? "****" : "++++++++");
		++count;
		}
	}

}
