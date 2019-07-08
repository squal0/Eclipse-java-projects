/**
 * 
 */

/**
 * @author Oracion Seis
 *the following program demonstrates recursive binary search
 */
import java.io.*;
class OrderedArray{
	private double [] a; // refremce to the array a
	private int nElements; // number of data items
	public OrderedArray(int max){ // constructor
		a = new double [max];// create the array
		nElements  =0;
	}
	public int size(){
		return nElements;
	}
	public int find(double searchKey){
		return recFind(searchKey, 0, nElements);
	}
	public int recFind(double searchKey , int LB, int UB){
		int cIndex;
		cIndex = (LB + UB)/ 2; 
		if(a[cIndex] == searchKey)
			return cIndex; // found the the search key
		else if (LB > UB)
			return nElements; // can't find the search key
		else { // divide the range
			if (a[cIndex] < searchKey)
				return recFind(searchKey, cIndex + 1, UB); // its in its upper half
			else // it's in the lower half
				return recFind(searchKey, LB, cIndex -1);
		} // end divide range
	}// end recFind method
	public void insert(double value){ // put elements in the array
		int j;
		for(j =0; j< nElements; j++)// find where it goes
			if(a[j] > value) // linear search
				break;
		for(int k = nElements; k> j ; k--) // move the bigger one
			a[k ] = a[k-1];
		a[j] = value; // insert it
		nElements++ ; // increment it
	} // end insert
	public void display(){
		for (int j = 0; j< nElements; j++) // for each element
			System.out.println(a[j]+ " "); // display it
		System.out.println(" ");
	}// end class OrderedArray
}
public class RBinarySearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
int maxSize = 100; //  array size
OrderedArray array = new OrderedArray (maxSize); // refrence to the array while creating the array
array.insert(66969); // insert the items
array.insert(9072);
array.insert(25252);
array.insert(1349);
array.insert(7879);
array.insert(10343);
array.insert(5743);
array.insert(383);
array.insert(7142);
array.insert(902);
array.insert(534);
array.insert(89252);
array.insert(167);
array.insert(7535);
array.insert(2756);
array.insert(971);
array.insert(8733);
array.insert(197);
array.insert(866);
array.insert(252);
array.insert(1797);
array.insert(8711);
array.insert(199);
array.insert(768);
array.insert(909);
array.insert(783);
array.insert(655);
array.insert(542);
array.insert(164);
array.insert(8586);
array.insert(309);
array.insert(1900);
array.insert(69);
array.insert(4667);
array.insert(9076);
array.insert(1886);
array.insert(468);
array.insert(18);
array.display(); // display the array
System.out.println("Enter a search Key");
int searchKey = getInt(); // search for the item
if (array.find(searchKey)!= array.size())
System.out.println("Found the searchKey " + searchKey);
else
	System.out.println("can't find the searchKey " + searchKey);
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
