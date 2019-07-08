/**
 * 
 */
package sortingAdvance;

/**
 * @author Oracion Seis
 *the following program demonstrates the partitioning of an array
 */
class Partition{
	private double [] pArray; //  refrence to array sArray
	private int nElements; // number of data items
	
	public Partition(int max){ // constructor
		pArray  = new double[max]; // create the array
		nElements  = 0; // no items yet in the array
	}
	public void insert(double value){
		pArray[nElements] = value; // insert it
		nElements ++; // increment size
	}
	public int size(){ // return the number of items
		return nElements;
	}
	public void display(){ // display the array contents 
		System.out.println("A= ");
		for(int j =0; j< nElements; j++) // for each element
			System.out.println(pArray[j] + " ") ; // display the contents of the array
		System.out.print(" ");
	}
	public int partitionIT(int left , int right , double pivot){
		int leftPtr  = left - 1; // right of the first element 
		int rightPtr  = right + 1; // left of the pivot
		while (true){
			while (leftPtr < right && // find the bigger item 
					pArray[++ leftPtr]< pivot); // (nop)
			while (rightPtr > left && // find the smaller item 
					pArray[--rightPtr]> pivot); // (nop)
				if (leftPtr >= rightPtr) // if pointers cross
					break; // partition done
				else swap(leftPtr, rightPtr);
		}
		return leftPtr; // return partition
	}
	public void swap(int dex1, int dex2){
	double temp;
	temp = pArray[dex1]; // A into temp
	pArray [dex1] = pArray[dex2]; // B into A
	pArray[dex2] = temp; // temp into B
	}
}
public class Partitioning {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxSize  = 20; //  array size
	Partition par= new Partition(maxSize); // create the array and fill the array with elements
		for(int x = 0; x< maxSize; x++){
			// generate random numbers
			double n = (int)(java.lang.Math.random()* 299);
			par.insert(n);
		}
		par.display(); // display unsorted array
		double pivot = 199; // pivot value
		System.out.println("Pivot is" + pivot);
		int size  = par.size();
		// partition the array
		int partDex  = par.partitionIT(0, size-1, pivot);
		System.out.println(", Partition is at index" + partDex);
		par.display(); // display the sorted array
	} // end main
} // end class Partitioning
