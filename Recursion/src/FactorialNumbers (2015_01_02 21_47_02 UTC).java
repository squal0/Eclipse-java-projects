

/**
 * 
 */

/**
 * @author Oracion Seis
 *the following program uses recursion to get the factorial of a number
 *Similar to the triangular numbers though 2 differences exist
 * 1: base case is = 0
 * 2: the factorial numbers use * and not +
 */
import java.io.*;
public class FactorialNumbers {
	public static int aNumber;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		System.out.println("Enter a number: ");
		System.out.flush();
		aNumber = getInt();
		int theAnswer = Factorial(aNumber);
		System.out.println("Factorial = "+ theAnswer);
			} //end main()
			public static int Factorial (int f){
				System.out.println(" Entering t= " + f);
				if (f == 0){
					System.out.println("Returning 1");
					return 1;
				}
				else
				{
					int temp = f * Factorial (f-1);
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
