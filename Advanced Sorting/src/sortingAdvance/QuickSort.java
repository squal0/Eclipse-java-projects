/**
 * 
 */
package sortingAdvance;

/**
 * @author Oracion Seis
 *the following program demonstrates the quick sort which is considered the fastest sorting algorithm
 *It works by partitioning an array into 2 sub arrays then sorting them
 *the following program is a recursive quick sort which works through recursion
 *this is a simple quick sort version
 */
class ArrayQuick{
	private double [] qArray; //  refrence to array sArray
	private int nElements; // number of data items
	
	public ArrayQuick(int max){ // constructor
		qArray  = new double[max]; // create the array
		nElements  = 0; // no items yet in the array
	}
	public void insert(double value){
		qArray[nElements] = value; // insert it
		nElements ++; // increment size
	}
	public void display(){ // display the array contents 
		System.out.println("A= ");
		for(int j =0; j< nElements; j++) // for each element
			System.out.println(qArray[j] + " ") ; // display the contents of the array
		System.out.print(" ");
	}
	public void qSort(){
		recQuickSort(0, nElements-1);
	}
	public void recQuickSort(int left , int right){
		if (right -left <= 0) //if size is <= 1
			return; // already sorted
		else{ // size 2 or larger
			double pivot = qArray[right]; // right most item
			int partition  = partitionIT(left, right , pivot);
			recQuickSort (left , partition -1); // sort the left side of the array
			recQuickSort(partition + 1, right); // sort the right side of the array
		}
	}
	public int partitionIT(int left , int right , double pivot){
		int leftPtr  = left - 1; // right of the first element 
		int rightPtr  = right; // left of the pivot
		while (true){
			while (qArray[++ leftPtr]< pivot); // find the bigger item 
					 // (nop)
			while (rightPtr > 0 && // find the smaller item 
					qArray[--rightPtr]> pivot); // (nop)
				if (leftPtr >= rightPtr) // if pointers cross
					break; // partition done
				else swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);
		return leftPtr; // return partition
	}
	public void swap(int dex1, int dex2){
	double temp;
	temp = qArray[dex1]; // A into temp
	qArray [dex1] = qArray[dex2]; // B into A
	qArray[dex2] = temp; // temp into B
	}
}
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize  = 1000; //  array size
		ArrayQuick arrayQ = new ArrayQuick(maxSize); // create the array and fill the array with elements
			for(int x = 0; x< maxSize; x++){
				// generate random numbers
				double n = (int)(java.lang.Math.random()* 1999);
				arrayQ.insert(n);
			}
			arrayQ.display(); // display unsorted array
			arrayQ.qSort(); // quick sort them
			arrayQ.display();
	}

}
