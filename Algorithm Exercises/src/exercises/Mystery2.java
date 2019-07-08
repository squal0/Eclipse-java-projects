/**
 * 
 */
package exercises;

/**
 * @author Home
 *
 */
public class Mystery2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int row = 10;
		
		while (row >= 1)
		{
		int column = 1;
		
	    while (column <= 10)
		{
		System.out.print(row % 2 == 1 ? "<" : ">");
		++column;
		 }
	
		--row;
		System.out.println();
		}
	}

}
