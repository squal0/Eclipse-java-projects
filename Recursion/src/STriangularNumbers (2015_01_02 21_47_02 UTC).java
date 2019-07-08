/**
 * 
 */

/**
 * @author oracion seis
 *the following program evaluates triangular numbers
 *this program performs the same function as the previous triangular numbers program
 *the only difference is that a stack approach replaces the recursive approach
 */
import java.io.*;
class Parameters{ // the parameteres to save on the stack
	public int n;
	public int returnAddress;
	public int cPart;
	public Parameters(int nn, int rA){
	returnAddress = rA;	
	}
} //end class Parameters
class StackX{
	private int maxSize; // size of the stack array
	private Parameters[] stackArray;
	private int top; // top of the stack
	public StackX(int s){ // constructor
		maxSize  = s; // set the array size
		stackArray = new Parameters[maxSize]; // create the array
		top = -1; // no items yet
	}
	public void push(Parameters p){ // put item on top of the stack
		stackArray [++ top ] =p; // increment top, insert p
	}
	public Parameters pop(){ // take item from the top of the stack
		return stackArray[top --]; // access the item, decrement
	}
	public Parameters peek(){ // peek at the top of the stack
		return stackArray[top]; 
	}
} // end class StackX
public class STriangularNumbers {

	/**
	 * @param args
	 */
	static int aNumber; 
	static int anAnswer;
	static StackX aStack;
	static int cPart;
	static Parameters theseParams;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.out.print("Enter a number: ");
		System.out.flush();
		aNumber  = getInt();
		recTriangle();
		System.out.println("Triangle  = "+ anAnswer);
	} // end main()
	public static void recTriangle(){
		aStack = new StackX(50);
		cPart =1;
		while(step()== false) // call step until it's true
			;
	}
	public static boolean step(){
switch (cPart){ // switch conditional statement
case 1: // initial call
	theseParams = new Parameters(aNumber , 6);
	aStack.push(theseParams);
	cPart = 2;
	break;
case 2: // method entry
	theseParams = aStack.peek();
	if(theseParams.n  == 1){ // test
	anAnswer =1;
	cPart  = 5; // exit
	}
	else 
		cPart = 3; // recursive call
	break;
case 3: // method call
	Parameters newParams = new Parameters(theseParams.n - 1, 4);
	aStack.push(newParams);
	cPart = 2; // go enter the method
	break;
case 4: // calculation
	theseParams = aStack.peek();
	anAnswer = anAnswer + theseParams.n;
	cPart =5;
	break;
case 5: // method exit
	theseParams  = aStack.peek();
	cPart = theseParams.returnAddress; //(4 or 6)
	aStack.pop();
	break;
case 6: // return point
	return true;
}
return false; // all but 7
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

