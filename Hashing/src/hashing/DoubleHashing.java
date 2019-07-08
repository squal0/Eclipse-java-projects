/**
 * 
 */
package hashing;

/**
 * @author Squalo
 *the following program implements double hashing which is another method of open adressing
 *it tends to rehash or hash the key a second time so as to eliminate both primary clustering found in linear probring
 *and secondary clustering found in quadratic probing
 */

import java.io.BufferedReader;
import java.io.IOException; // for i/o operations
import java.io.InputStreamReader;
// for the stack class
class DataItem1{
	//could have more than one data item but for simplicity I used one
		public int iData; // data item
		public DataItem1(int ii){ // constructor
			iData  = ii;
		}
		} // end class
class HashTable1{
	DataItem1 [] hashArray; // the array that holds the hash table
	int arraySize; 
	DataItem1 nonItem; // for deleted items
	public HashTable1 (int size){ // constructor
		arraySize  = size; 
		hashArray = new DataItem1[arraySize] ;
		nonItem = new DataItem1(-1); // deleted item key is -1
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
		return key % arraySize; // hash function
	}
	public int hFunction2(int key){
		// non zero, less than array size and prefferably a prime number and different from the first hash function
		return 11 - (key % 11);
	}
	public void insert (DataItem1 item , int key){ // insert the data item
		//assumes table is not full
		int hashValue  = hFunction(key); // hash the key
		int stepSize  = hFunction2(key); // get the step size
		// until empty cell or -1
		while (hashArray [hashValue] != null && hashArray [hashValue].iData != -1){
			hashValue += stepSize; // add the step
			hashValue %= arraySize; // wrap around if necessary
		}
		hashArray [hashValue] = item; // insert item
	} // end insert()
	public DataItem1 delete(int key){ // delete a Data item
		int hashValue = hFunction(key); // hash key
		int stepSize =  hFunction2(key); // get the step size
		while (hashArray[hashValue] != null){ // until empty cell
			// found the key?
			if(hashArray [hashValue].iData == key){
				DataItem1 temp = hashArray[hashValue]; // save item
				hashArray [hashValue] = nonItem; // delete item
				return temp; // return item
			}
		 hashValue += stepSize; // add the step
			hashValue %= arraySize; // wrap around if necessary
		}
		return null ; // can't find item
	} // end delete()
	public DataItem1 find(int key){
		int hashValue = hFunction(key); // hash key
		int stepSize  = hFunction2(key); // get the step
		while (hashArray[hashValue] != null){ // until empty cell
			// found the key?
			if(hashArray [hashValue].iData == key)
				return hashArray[hashValue]; // yes , return item
				 hashValue += stepSize; // add the step
				hashValue %= arraySize; // wrap around if necessary
		}
			return null; // can't find the item
	}
}
public class DoubleHashing {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataItem1 dt;
		 int aKey , size , n;
		 // get sizes
		 putText("Enter size of hash table: ");
		 size = getInt();
		 putText("Enter initial number of items: ");
		 n = getInt();
		  // make table
		 HashTable1 theHash = new HashTable1(size);
		 for(int j =0; j<n; j++){ // insert the data
			 aKey = (int)(java.lang.Math.random()* 2 * size);
			 dt = new DataItem1(aKey);
			 theHash.insert(dt, aKey);
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
				 dt = new DataItem1(aKey);
				 theHash.insert(dt, aKey);
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


