/**
 * 
 */

/**
 * @author Oracion Seis 
 * the following program shows the sorting of a list
 *
 */
class Link1{
	public double dData; // data item
	public Link1 next; //the next link in the list
public Link1(double dd){ // constructor
	dData = dd;
}
public void displayLink(){ // display this link
	System.out.print(dData + "");
}
}// end class Link1
class SortedList{
	private Link1 first; // refer to first item
	public SortedList(){ // constructor
		first = null; // no items in the list
	}
	public boolean isEmpty(){ // return true if no links are available
		return (first == null);
	}
	public void insert(double key){ // insert in order
		Link1 newLink = new Link1(key); // make new link
		Link1 previous = null; // start a first
		Link1 current = first;
		// until the end of the list
		while (current  != null && key > current.dData){ // or key > current 
			previous = current;
			current = current.next; // go to the next item
		}
		if(previous == null) // at the beggining of the list
			first = newLink; // first ----> newLink
		else // not at the beggining 
			previous.next = newLink; // old previous -----> newLink
		newLink.next = current; // newLink ----> old current
	}// end insert
	public Link1 remove(){ // return & delete the first link
		// assumes that the list is non-empty
		Link1 temp = first; // save first
		first  = first.next; // delete first
		return temp;
	}	
	public void displayList(){ 
		System.out.print("List(First -----> last):");
		Link1 current  = first; // start at the beginning
		while (current != null){// until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next link
			System.out.println("");
		}
	}
	
}// end class SortedList
public class SortList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
// create a new list
		SortedList SList = new SortedList();
		SList.insert(74745); // insert items
		SList.insert(687);
		SList.insert(123);
		SList.insert(653);
		SList.insert(905);
		SList.displayList(); // display the list
		SList.insert(86543);
		SList.insert(227);
		SList.insert(978);
		SList.insert(1578);
		SList.insert(5858);
		SList.displayList(); 
		SList.remove(); // remove items from the list
		SList.remove();
		SList.remove();
		SList.displayList(); // display after removing items from the list
	}// end main

}// end class SortList
