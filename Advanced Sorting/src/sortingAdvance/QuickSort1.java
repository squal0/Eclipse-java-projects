/**
 * 
 */
package sortingAdvance;

/**
 * @author Oracion Seis
 * the following program demonstrates a quick sort using the median of three partitioning
 *this partitioning prevents the quick sort algorithm from degenerating to O(N2) performance
 */
class ArrayQ{
	private double [] qArray; //  refrence to array sArray
	private int nElements; // number of data items
	
	public ArrayQ(int max){ // constructor
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
	public void recQuickSort(int left, int right){
		int size = right - left +1;
		if(size <= 3) // manual sort if small
			manualSort(left,right);
		else { // quick sort if large
			double median = medianOf3( left, right);
			int partition = partitionIT(left, right, median);
			recQuickSort (left, partition - 1);
			recQuickSort (partition + 1 , right);
		}
	} // end recQuickSort
	public double medianOf3(int left, int right){
		int center  = (left + right)/ 2;
		// order left and center
		if (qArray [left] > qArray[center])
			swap(left, center);
		if (qArray [left] > qArray[right])
			swap(left, right);
		// order center and right
		if (qArray [center] > qArray[right])
			swap(center, right);
		swap(center , right-1); // put the pivot on the right
		return qArray[right -1]; // return the median value
		
	}
	public void swap(int dex1, int dex2){
		double temp;
		temp = qArray[dex1]; // A into temp
		qArray [dex1] = qArray[dex2]; // B into A
		qArray[dex2] = temp; // temp into B
		}
	public int partitionIT(int left , int right , double pivot){
		int leftPtr  = left; // right of the first element 
		int rightPtr  = right -1; // left of the pivot
		while (true){
			while (qArray[++ leftPtr]< pivot); // find the bigger item 
					 // (nop)
			while (qArray[-- rightPtr] > pivot); // find the smaller item
			//(nop)
				if (leftPtr >= rightPtr) // if pointers cross
					break; // partition done
				else swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right -1); // restore the pivot
		return leftPtr; // return pivot location
	} // end partitionIT()
	public void manualSort(int left, int right){
	int size = right - left +1;
	if(size <= 1)
		return; // no need for sorting
	if (size  == 2){  // 2- sort left and right
		if(qArray[left] > qArray[right])
			swap(left, right); // left, right
		return;
	}
		else{ // size is 3
			// 2- sort  left , center(right -1) and right
			if(qArray[left]  > qArray [right -1])
				swap(left , right -1); // left , center
			if(qArray[left] > qArray[right])
				swap(left, right); // left, right
			if(qArray[right -1] > qArray[right])
				swap(right -1, right); // center , right
		}
	}// end manual sort
} //end class ArrayQ1
public class QuickSort1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize  = 1000; //  array size
		ArrayQ arrayQ = new ArrayQ(maxSize); // create the array and fill the array with elements
			for(int x = 0; x< maxSize; x++){
				// generate random numbers
				double n = (int)(java.lang.Math.random()* 1999);
				arrayQ.insert(n);
			}
			System.out.println("Before sorting");
			arrayQ.display(); // display unsorted array
			arrayQ.qSort(); // quick sort them
			System.out.println("After sorting");
			arrayQ.display();
	}

}
