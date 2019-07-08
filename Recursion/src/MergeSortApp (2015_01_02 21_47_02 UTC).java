/**
 * 
 */

/**
 * @author oracion seis
 * the following program demonstrates the use of a merge sort to sort the elements of the given array
 *unlike the first merge program this one only works on one array 
 */
import java.io.*;
class MArray{
	private double[] theArray; // refrence to the array
	private int nElements; // number of data items
	public MArray(int max){
		theArray = new double [max]; // create the array
		nElements =0;
	}
	public void insert(double value) { // put elements in the array
		theArray[nElements] = value; // insert it
		nElements ++; // increment size
		}
	public void display(){ // display the array contents 
		for(int j =0; j< nElements; j++) // for each element
			System.out.println(theArray[j] + " ") ; // display the contents of the array
		System.out.print(" ");
	}
	public void mergeSort(){ // will be called by main
		// provides workspace
		double []workspace = new double [nElements];
		recMergeSort(workspace ,0, nElements -1);
	}
	public void recMergeSort(double [] workspace ,int LBound, int UBound){
	if (LBound  == UBound) // if range is 1
		return; // use no sorting 
	else {
		// find the mid point
		int mid  = (LBound + UBound)/ 2;
		// sort the low half
		recMergeSort(workspace , LBound , mid);
		// sort the upper half
		recMergeSort (workspace , mid+1 , UBound);
		// merge them
		merge(workspace, LBound , mid+1, UBound);
	} //end else
	}// end recMergeSort
	public void merge(double []workspace, int LP, int HP , int UBound){
		int j =0; // workspace index
		int LBound = LP;
		int mid = HP - 1;
		int n = UBound - LBound +1; // number of items
		while (LP <= mid && HP <= UBound)
			if (theArray[LP] < theArray[HP])
				workspace[j++] = theArray[LP++];
			else 
				workspace[j++] = theArray[HP++];
		while (LP <= mid)
				workspace[j++] = theArray[LP++];
		while (HP <= UBound)
				workspace[j++] = theArray[HP++];
		for (j =0; j< n; j++)
			theArray[LBound + j] = workspace[j];
	} // end merge()
} // end class MArray
public class MergeSortApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
int maxSize  = 100; // array size
MArray array = new MArray(maxSize);
System.out.println("Inserting data items into the array");
array.insert(6969);
array.insert(66969);
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
System.out.println("Before Merge sorting");
array.display(); // display the items
array.mergeSort(); // merge sort the array
System.out.println("After Merge sorting");
array.display(); // display the items again after sorting
	} // end main()
} // end class MergeSortApp
