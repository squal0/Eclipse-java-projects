/**
 * 
 */

/*
 * @author Oracion seis
 * the following program shows a sorted list that is used in sorting 
 * it uses the insertionn sort but this one is more faster when time complexity is
 * considered
 *
 */
class Link2{
	public double dData; // data item
	public Link2 next; //the next link in the list
public Link2(double dd){ // constructor
	dData = dd;
}
} // end class Link2
class SList{
	private Link2 first; // refer to first item
	public SList(){ // constructor no arguments
		first = null; // no items in the list
	}
	public SList(Link2[] LinkArr){ // constructor (array here is used as an argument)
		first = null ; // intialize the listt
		for( int j=0; j<LinkArr.length; j++)// copy array
			insert(LinkArr[j]); // to the list 
	}
	public void insert(Link2 k) { // insert in order
	Link2 previous = null; // start at first 
	Link2 current = first;
	// until the end of the list
	while(current!= null && k.dData> current.dData){ // or key > current
		previous = current;
		current = current.next; // go to the next item
	}
	if(previous == null) // at the beginning of the list
		first = k; // first---> k
	else // not at the beginning
		previous.next = k; // old previous---> k
	k.next = current; // k-----> old current
	} // end insert
	public Link2 remove(){ // return & delete the first link
		// assumes that the list is non-empty
		Link2 temp = first; // save first
		first  = first.next; // delete first
		return temp;
	}	
} // end class SList
public class SortingList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
int size  = 20; 
// create array of links
Link2[]linkArray = new Link2[size];
for (int j =0; j< size; j++){ // fill the array with links
	// random number
	int n = (int)(java.lang.Math.random()* 100);
	Link2 newLink = new Link2(n); // make a new Link
	linkArray[j] = newLink; // put in the array
	}
// display the array contents
System.out.print("Unsorted array:");
for(int j =0; j< size; j++)
	System.out.print(linkArray[j].dData+ "");
System.out.println(" ");
// create a new list
// initialized with the array
SList sList = new SList(linkArray);
for (int j =0; j< size; j++) // links from the list to the array
	linkArray[j] = sList.remove();
// display the array contents
System.out.print("Sorted array:");
for(int j =0; j< size; j++)
	System.out.print(linkArray[j].dData+ "");
System.out.println(" ");
	} // end main

} // end class SortingList
