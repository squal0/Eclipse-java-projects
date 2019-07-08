/**
 * 
 */
package hashing;

import java.io.BufferedReader;
import java.io.IOException; // for i/o operations
import java.io.InputStreamReader;
// for the stack class
/**
 * @author Squalo
 * the following program uses quadratic probing as a method of open addressing
 * quadratic probing eliminates the primary clusters found in the linear probing method
 */
class DataItem2{
	//could have more than one data item but for simplicity I used one
	public int iData; // data item
	public DataItem2(int ii){ // constructor
		iData  = ii;
	}
	} // end class
	class HashTable2{
		DataItem2 [] hashArray; // the array that holds the hash table
		int arraySize; 
		DataItem2 nonItem; // for deleted items
		public HashTable2 (int size){ // constructor
			arraySize  = size; 
			hashArray = new DataItem2[arraySize] ;
			nonItem = new DataItem2(-1); // deleted item key is -1
		}
		public void display(){
		System.out.print("Table");
		for (int j =0; j < arraySize; j++){
			if (hashArray[j] != null)
				System.out.println(hashArray[j].iData + " ");
			else
				System.out.println("** ");
		}
		System.out.println(" ");
		}
		public int hFunction (int key){
			return key*key % arraySize; // hash function
		}
		public void insert (DataItem2 item){ // insert the data item
			//assumes table is not full
			int key = item.iData; // extract key
			int hashValue  = hFunction(key); // hash the key
			// until empty cell or -1
			while (hashArray [hashValue] != null && hashArray [hashValue].iData != -1){
				++ hashValue; // go to next cell
				hashValue %= arraySize; // wrap around if necessary
			}
			hashArray [hashValue] = item; // insert item
		} // end insert()
		public DataItem2 delete(int key){ // delete a Data item
			int hashValue = hFunction(key); // hash key
			while (hashArray[hashValue] != null){ // until empty cell
				// found the key?
				if(hashArray [hashValue].iData == key){
					DataItem2 temp = hashArray[hashValue]; // save item
					hashArray [hashValue] = nonItem; // delete item
					return temp; // return item
				}
				++ hashValue; // go to the next cell
				hashValue %= arraySize; // wrap around if necessary
			}
			return null ; // can't find item
		} // end delete()
		public DataItem2 find(int key){
			int hashValue = hFunction(key); // hash key
			while (hashArray[hashValue] != null){ // until empty cell
				// found the key?
				if(hashArray [hashValue].iData == key)
					return hashArray[hashValue]; // yes , return item
					++ hashValue; // go to next cell
					hashValue %= arraySize; // wrap around if necessary
			}
				return null; // can't find the item
		}
		}
public class QuadraticProbing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataItem2 dt;
		 int aKey , size , n, keysPerCell;
		 // get sizes
		 putText("Enter size of hash table: ");
		 size = getInt();
		 putText("Enter initial number of items: ");
		 n = getInt();
		 keysPerCell = 100;
		  // make table
		 HashTable2 theHash = new HashTable2(size);
		 for(int j =0; j<n; j++){ // insert the data
			 aKey = (int)(java.lang.Math.random()* keysPerCell * size);
			 dt = new DataItem2(aKey);
			 theHash.insert(dt);
		 }
		 while (true){ // interact with the user
			 putText ("Enter the first letter of: ");
			 putText(" show , insert , delete or find:");
			 char choice = getChar();
			 switch (choice){
			 case 's':
			 theHash.display();
			 break;
			 case 'i':
				 putText("Enter the key value to insert:");
				 aKey = getInt();
				 dt = new DataItem2(aKey);
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

