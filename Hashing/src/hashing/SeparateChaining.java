/**
 * 
 */
package hashing;

/**
 * @author Squalo
 * the following program uses separate chaining as a solution of collisions found in hash tables 
 * separate chaining uses linked lists at each index in the hash table
 * separate chaining load factor maybe 1  or greater and the table size need not be a prime number 
 * as in quad probing or double hashing.
 */
import java.io.BufferedReader;
import java.io.IOException; // for I/O
import java.io.InputStreamReader;
// for stack class

class Link{
	// could be other items
	public int iData; // data item
	public Link next; // the next link in the list
	
	public Link(int id){ // constructor
		iData = id; 
	}
	public void displayLink(){ // displays the link
		System.out.print(iData + " ");
	}
} // end class Link
class SortedList{
	private Link first; // refers to the first item on the list
	public SortedList(){ // constructor
		first = null;
	}
	public void insert (Link aLink){ // insert link in order
		int key = aLink.iData;
		Link previous  = null; // start at first
		Link current = first;
		 // until the end of the list
		while (current != null && key > current.iData){
			previous = current;
			current = current.next; // go to the next item
		}
		if (previous == null) // if it's the beggining of the list
			first  = aLink; // first ----> new Link
			else // not at the beginning
				previous.next = aLink; // previous -----> newLink
			aLink.next = current; // new Link -----> current
	}
	public void delete (int key){ // delete the link
		// assumes the list is non-empty
		Link previous = null; // start at first
		Link current = first;
		// until end of list
		while (current != null && key != current.iData){
			// or key == current
			previous = current; 
			current = current.next; // go to the next link
		} 
		// disconnect the link
		if(previous == null) // if it's the beginning of the list
			first = first.next; // delete the frst link
			else // not at the beginning
				previous.next = current.next; // delete the current link
	} // end delete
	public Link find (int key){ // find the link
		Link current = first; // start at the link's first item
		// until the end of the list
		while(current != null && current.iData <= key){
			// key too small
			if (current.iData == key) // is this the link?
				return current; // found it, return to the link
			current  = current.next; // go to the next item
		}
		return null; // didn't find it
	} // end find()
	public void displayList(){
		System.out.print("List (first ---> last): ");
		Link current = first; // start at the beginning of list
		while (current != null){ // until end of the list
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.println(" ");
	}
} // end class SortedList
class HashTable3{
	private SortedList [] hashArray; // array of list
	private int arraySize;
	public HashTable3(int size){ // constructor
		arraySize = size;
		hashArray = new SortedList[arraySize]; // create array
		for(int j = 0; j< arraySize; j++)// fill array
			hashArray[j] = new SortedList(); // with lists
	}
	public void displayTable(){
		for (int j=0; j<arraySize; j++){ // for each cell
			hashArray[j].displayList(); // display the list
	}
	}
	public int hFunction3(int key){ // hash function
		return key % arraySize;
	}
	public void insert(Link aLink){ // insert a link
		int key = aLink.iData;
		int hashValue = hFunction3(key); // hash the key
		hashArray[hashValue].insert(aLink); // insert at hashValue
	} // end insert()
	public void delete(int key){ // delete a link
		int hashValue = hFunction3(key); // hash the key
		hashArray[hashValue].delete(key); // delete link
	} // end delete()
	public Link find(int key){ // find link
		int hashValue = hFunction3(key); // hash the key
		Link aLink = hashArray[hashValue].find(key); // get the link
		return aLink; // return the link
	}
} // end class HashTable3
public class SeparateChaining {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
int aKey;
Link dt;
int size, n, keysPerCell = 100;
// get sizes
putText("Enter size of hash table: ");
size = getInt();
putText("Enter initial number of items: ");
n = getInt();
 // make table
HashTable3 theHash = new HashTable3(size);
for(int j =0; j<n; j++){ // insert the data
	 aKey = (int)(java.lang.Math.random()* keysPerCell * size);
	 dt = new Link(aKey);
	 theHash.insert(dt);
}
while (true){ // interact with the user
	 putText ("Enter the first letter of: ");
	 putText(" show , insert , delete or find:");
	 char choice = getChar();
	 switch (choice){
	 case 's':
	 theHash.displayTable();
	 break;
	 case 'i':
		 putText("Enter the key value to insert:");
		 aKey = getInt();
		 dt = new Link(aKey);
		 theHash.insert(dt);
		 break;
	 case 'd':
		 putText("Enter value to delete:");
		 aKey = getInt();
		 theHash.delete(aKey);
		 break;
	 case 'f':
		 putText("Enter the value to find:");
		 aKey = getInt();
		 dt = theHash.find(aKey);
		 if(dt != null){
			 System.out.println("Found " + aKey);
		 }
		 else
			 System.out.println("Could not find "+ aKey);
		 break;
		 default:
			 putText("Invalid entry\n");
	 }
}
	}
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
