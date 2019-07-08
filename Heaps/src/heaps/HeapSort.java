/**
 * 
 */
package heaps;

/**
 * @author Squalo
 * the following program demonstrates a heap sort 
 * it uses a dual purpose array and trickles down method to increase the efficiency of the array
 */
import java.io.*; // for i/o operations
import java.lang.Integer; // for parse int
class Node1{
	public int iData; // data item (key)
	public Node1(int key){// constructor
		iData  = key;
	}
}
class Hp1{
	private Node1 [] heapArray;
	private int maxSize; // size of the array
	private int currentSize; // number of nodes in array
	
	public Hp1 (int max){ // constructor
		maxSize = max;
		currentSize = 0;
		heapArray = new Node1 [maxSize]; // create the array
	}
	public Node1 remove(){ // delete the item with the max key
		// assumes the list is not empty
		Node1 root = heapArray[0];
		heapArray[0] = heapArray [-- currentSize];
		trickleDown(0);
		return root;	
	} // end remove()
	public void trickleDown(int index){
	int largerChild;
	Node1 top = heapArray[index] ; // save the root
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
public void displayArray(){
	for(int j = 0; j < maxSize; j++)
		System.out.println(heapArray[j].iData + " ");
	System.out.println(" ");
}
public void insertAt(int index , Node1 newNode){
	heapArray[index] = newNode;
}
public void incrementSize(){
	currentSize++;
}
}
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException{
		// TODO Auto-generated method stub
int size, j;
System.out.print("Enter the number of items");
size = getInt();
Hp1 theHeap = new Hp1(size);
for(j = 0; j<size; j++){ // fill the array
	// random numbers or nodes
	int random = (int) (java.lang.Math.random()* 10000);
	Node1 newNode = new Node1(random);
	theHeap.insertAt(j, newNode);
	theHeap.incrementSize();
}
System.out.print("Random");
theHeap.displayArray(); // display the array filled with random nodes
for(j = size/2-1; j>= 0; j--) // make the random array into a heap
	theHeap.trickleDown(j);
System.out.print("Heap: ");
theHeap.displayArray(); // display the array
theHeap.displayHeap(); // display the heap
for(j =size -1; j>=0; j--){ // remove items from the heap
	// and store them at the array end
	Node1 biggestNode = theHeap.remove();
	theHeap.insertAt(j, biggestNode);
}
System.out.print("Sorted");
theHeap.displayArray(); // display the sorted array
	}
	public static String getString() throws IOException{
		InputStreamReader isr  = new InputStreamReader(System.in);
		BufferedReader br  = new BufferedReader(isr);
		String s  = br.readLine();
		return s;
	}
	public static int getInt() throws IOException{
		String s  = getString();
		return Integer.parseInt(s);
	}
}
