/**
 * 
 */

/**
 * @author oracion seis
 *the following program uses recursion to find anagrams of a word inputed 
 *by the user.
 */
import java.io.*;
public class Anagramming {
static int size;
static int count;
static char[] arrayC = new char [100];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
System.out.println("Enter a word"); // get input from the user
System.out.flush();
String input  = getString();
size = input.length(); // find the size of the inputed word
count  = 0;
for (int j = 0; j < size; j++){// put the word in an array
	arrayC [j] = input.charAt(j);
	dAnagram(size); // anagram it
}
} // end main()
public static void dAnagram(int newSize){
	if (newSize == 1) // if word is too small
		return; // go no further
	for (int j =0;  j< newSize; j++){// for each position
		dAnagram (newSize- 1); // anagram remaining
		if (newSize == 2) // if innermost
			displayWord(); // display it
		    rotate(newSize); // rotate word
	}
}
	// rotate all left characters from current position to the end
public static void rotate(int newSize){
	int j;
	int position = size - newSize;
	char temp = arrayC[position]; // save the first letter of the word
	for (j = position + 1; j< size; j++){// shift all other letters
		arrayC [j-1] = arrayC [j];
		arrayC [j-1] = temp; // put the first on the right
	}
}
public static void displayWord(){
	if(count < 999)
		System.out.print(" ");
	if (count < 99)
		System.out.print(" ");
	System.out.print(++ count +" ");
	for(int j =0; j< size; j++)
		System.out.print(arrayC[j]);
	System.out.print(" ");
	System.out.flush();
	if (count % 66 == 0)
		System.out.print(" ");
}
	public static String getString() throws IOException{
		InputStreamReader word  = new InputStreamReader(System.in);
		BufferedReader sent  = new BufferedReader(word);
		String s  = sent.readLine();
		return s;
	}
}
