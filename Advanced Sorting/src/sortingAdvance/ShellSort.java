/**
 * 
 */
package sortingAdvance;

/**
 * @author Oracion Seis
 *the following program simulates the under taking of a shell sort
 *Shell sort is an advanced type of sorting though it is based on the elementary merge sort
 */
class ShellArray{
	private double [] sArray; //  refrence to array sArray
	private int nElements; // number of data items
	
	public ShellArray(int max){ // constructor
		sArray  = new double[max]; // create the array
		nElements  = 0; // no items yet in the array
	}
	public void insert(double value){
		sArray[nElements] = value; // insert it
		nElements ++; // increment size
	}
	public void display(){ // display the array contents 
		for(int j =0; j< nElements; j++) // for each element
			System.out.println(sArray[j] + " ") ; // display the contents of the array
		System.out.print(" ");
	}
	public void S_Sort(){ // method for the shell sort
		int inner, outer;
		double temp;
		int h =1; // find the initial value of h
		while( h<= nElements/3)
			h = h*3+1; // gap sequence
		while(h> 0){ // decreasing h, until h=1
			// shell sort the file
			for (outer = h; outer < nElements; outer++){
				temp = sArray[outer];
				inner = outer;
				// one subpass
				while (inner > h -1 && sArray[inner -h] >= temp){
					sArray [inner] = sArray[inner - h];
					inner -=h ;
				}
				sArray[inner] = temp;
			} // end for loop
			h = (h-1)/3; // decrease h using the gap sequence formula
		} // end while (h>0)	
	} // end S_Sort
}// end class shell Array
public class ShellSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int maxSize  = 10000; //  array size
ShellArray shell = new ShellArray(maxSize); // create the array and fill the array with elements
for(int x = 0; x< maxSize; x++){
	// generate random numbers
	double n = (int)(java.lang.Math.random()* 99);
	shell.insert(n);
}
System.out.println("Unsorted array");
shell.display(); // display the unsorted array
shell.S_Sort(); // shell sort the random generated numbers in the array
System.out.println("Sorted array");
shell.display(); // display the sorted array;
	} // end main
}// end shell sort
