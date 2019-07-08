/**
 * 
 */

/**
 * @author Oracion seis
 *the following program uses recursion(method calling itself) to print a number series
 *it asks the user for input
 */
import java.io.*;
public class Triangularnumbers{
	public static int aNumber;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
System.out.println("Enter a number: ");
System.out.flush();
aNumber = getInt();
int theAnswer = triangle(aNumber);
System.out.println("Triangle = "+ theAnswer);
	} //end main()
	public static int triangle (int t){
		System.out.println(" Entering t= " + t);
		if (t == 1){
			System.out.println("Returning 1");
			return 1;
		}
		else
		{
			int temp = t + triangle (t-1);
		System.out.println(" Returning " + temp);
		return temp;
		}
	}
	public static String getString() throws IOException{
		InputStreamReader word  = new InputStreamReader(System.in);
		BufferedReader sent  = new BufferedReader(word);
		String s  = sent.readLine();
		return s;
	}
	public static int getInt()throws IOException{
		String s  = getString();
		return Integer.parseInt(s);
	} // end getInt()
}
