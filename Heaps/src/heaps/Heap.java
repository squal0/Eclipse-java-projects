/**
 * 
 */
package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Integer; // for parseInt()
/**
 * @author Squalo
 *the following program demonstrates heaps 
 *a heap is a somewhat binary tree that is considered a preffered choice when implementing
 *priority queue
 */
class Node{
	public int iData; // data item (key)
	public Node(int key){// constructor
		iData  = key;
	}
}
class Hp{
	private Node [] heapArray;
	private int maxSize; // size of the array
	private int currentSize; // number of nodes in array
	
	public Hp (int max){ // constructor
		maxSize = max;
		currentSize = 0;
		heapArray = new Node [maxSize]; // create the array
	}
	public boolean isEmpty(){
		return currentSize == 0;
	}
	public boolean insert(int key){
		if (currentSize == maxSize)
			return false;
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;	
	} // end insert()
	public void trickleUp(int index){
	int parent = (index -1) / 2;
	Node bottom = heapArray[index];
	while(index > 0 && heapArray[parent].iData < bottom.iData){
		heapArray[index] = heapArray[parent]; // move it down
		index  = parent;
		parent  = (parent - 1) / 2;
	}//end while
	heapArray[index] = bottom;
	} // end trickleUp()
	public Node remove(){ // delete the item with the max key
		// assumes the list is not empty
		Node root = heapArray[0];
		heapArray[0] = heapArray [-- currentSize];
		trickleDown(0);
		return root;	
	} // end remove()
	public void trickleDown(int index){
	int largerChild;
	Node top = heapArray[index] ; // save the root
	while(index < currentSize / 2){ // while node 
		// has atleast one child
		int leftChild  = 2*index + 1; 
		int rightChild = leftChild + 1;
		// find larger child
		if(rightChild < currentSize &&  //(does the right child exist?))
				heapArray[leftChild].iData < heapArray[rightChild].iData)
			largerChild = rightChild;
		else 
			largerChild  = leftChild;
		//top >= largerChild?
		if (top.iData >= heapArray[largerChild].iData)
			break;
		//shift child up
		heapArray[index] = heapArray[largerChild];
		index = largerChild; // go down
	} // end while()
	heapArray[index] = top; // root to index
	} // end trickleDown()
	public boolean change(int index, int newValue){
		if(index <0 || index >= currentSize)
			return false;
		int oldValue = heapArray[index].iData; // remember old value
		heapArray[index].iData = newValue; // change to new
		if(oldValue < newValue) // if raised
			trickleUp(index) ; // trickle it up
			else // if lowered
				trickleDown(index); // trickle it down
			return true;
		} // end change()
	public void displayHeap(){
		System.out.print("heapArray:"); // array format
		for(int m = 0; m < currentSize; m++)
			if(heapArray[m] != null)
				System.out.print(heapArray[m].iData + " ");
			else
				System.out.print("___");
		System.out.println();
		// heap format
		int nBlanks = 32;
		int itemsPerRow = 1;
		int column = 0;
		int j = 0; // current item
		String dots = "...............................................";
		System.out.println(dots + dots); // dotted top line
		while(currentSize > 0){ // for each heap item
			if (column == 0) // first item in a row
				for(int k = 0; k <nBlanks; k++) // preceding blanks
					System.out.print(' ');
					// display the item
					System.out.print(heapArray[j].iData);
					if(++ j == currentSize ) // done?
						break;
					if(++ column == itemsPerRow){ // end of row
						nBlanks /= 2; // half the blanks
						itemsPerRow *= 2; // twice the items
						column = 0; // start over on
						System.out.println(); // new row
					}
					else // next item on row
						for(int k = 0; k < nBlanks*2-2; k++)
							System.out.print(' '); // interim blanks
				} // end for
			System.out.println("\n " + dots + dots) ; // dotted bottom line
		}
		}// end displayHeap()	
public class Heap {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
int value, value2;
Hp theHeap = new Hp(50); // make a heap of max size 50
boolean success;
theHeap.insert(6969);
theHeap.insert(493);
theHeap.insert(292);
theHeap.insert(515);
theHeap.insert(106);
theHeap.insert(805);
theHeap.insert(1664);
theHeap.insert(706);
theHeap.insert(440);
theHeap.insert(809);
theHeap.insert(159);
theHeap.insert(924);
theHeap.insert(838);
theHeap.insert(659);
theHeap.insert(743);
theHeap.insert(458);
theHeap.insert(196);
theHeap.insert(727);
theHeap.insert(5967);
theHeap.insert(939);
theHeap.insert(162);
theHeap.insert(549);
theHeap.insert(405);
theHeap.insert(129);
while (true){ // until [Ctrl]- [C]
	
	putText("Enter the first letter of:");
	putText("Show, Insert, Change, Remove");
	int choice = getChar();
	switch(choice){
	 case 's':
		 theHeap.displayHeap();
		 break;
		 case 'i':
			 putText("Enter the key value to insert:");
			 value = getInt();
			 success = theHeap.insert(value);
			 if(!success)
				 putText("Can't insert: heap is full" + '\n');
			 break;
		 case 'r':
			 putText("Enter value to remove:");
			 if(!theHeap.isEmpty())
				 theHeap.remove();
			 break;
		 case 'c':
			 putText("Enter the index of the item to change:");
			value = getInt();
			putText ("Enter new priority:");
			value2 = getInt();
			success = theHeap.change(value, value2);
			if(!success)
				putText("Can't change : Invalid index" + '\n');
			break;
			 default:
				 putText("Invalid entry\n");
	} // end switch
	} // end while
	} // end main
	public static void putText (String s){
		System.out.print(s);
		System.out.flush();
	}
	public static String getString() throws IOException{
		InputStreamReader isr  = new InputStreamReader(System.in);
		BufferedReader br  = new BufferedReader(isr);
		String s  = br.readLine();
		return s;
	}
	public static char getChar() throws IOException{
		String s  = getString();
		return s.charAt(0);
	}
	public static int getInt() throws IOException{
		String s  = getString();
		return Integer.parseInt(s);
	}
}
