/**
 * 
 */

/**
 * @author Oracion Seis
 *the following program solves the towers of hanoi puzzle using the recursive approach
 *its more or less evaluating triangular numbers
 *the program does not simulate the real towers of hanoi but solves the problem on how to approach the puzzle itself
 */
import java.io.*;
public class Towers {
static int nDisks; // number of disks in the tower
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of disks in the puzzle");
		nDisks = getInt();
doTowers (nDisks, 'A','B','C');
	} // end main
public static void doTowers(int topN, char from, char inter, char to){
	if(topN == 1)
		System.out.println("Disk 1 from " + from + " to " + to);
	else{
		doTowers(topN -1, from, to, inter); // from----> inter
		System.out.println("Disk" + topN + " from "+ from + " to " + to );
		doTowers(topN -1, inter,from, to); // inter ----> to
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
} // end class towers
