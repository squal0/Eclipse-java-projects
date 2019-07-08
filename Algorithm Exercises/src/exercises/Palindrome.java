/**
 * 
 */
package exercises;

/**
 * @author Home
 *
 */
import java.util.Scanner;
public class Palindrome {

	/**
	 * @param args
	 */
	private static Scanner input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String original, reverse = "";
	    input = new Scanner(System.in);
	 
	      System.out.println("Enter a string to check if it is a palindrome");
	      original = input.nextLine();
	      int length = original.length();
	      if(original.length() != 5){
	    	  System.out.println("Error!, Please enter a string with 5 values");
	    	  length = 0;
	    	  System.out.println("Enter a string to check if it is a palindrome");
		      original = input.nextLine(); 
	      } 
	      
	      for ( int i = length - 1; i >= 0; i-- )
	         reverse += original.charAt(i);
	 
	      if (original.equals(reverse))
	         System.out.println("Entered string is a palindrome.");
	      else
	         System.out.println("Entered string is not a palindrome.");
	 
	   }

	}

