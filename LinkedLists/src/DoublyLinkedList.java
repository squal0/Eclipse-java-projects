/**
 * 
 */

/**
 * @author Oracion Seis
 *the following program demonstrates a doubly Linked list
 *this list has an advantage over the common Linked List
 *since one can traverse both forward and backwards
 *though it's disavantage is when inserting or deleting one has to deal with four links
 */
class DLink{
	public double dData; // data item
	public DLink next; // next link in the list
	public DLink previous; // previous link in the list
	public DLink(double d){ // constructor
		dData = d;
	}
	public void displayLink(){ // display this link
		System.out.print(dData + "");
	}
}// end class DLink
class DLList{
	private DLink first; // refer to first item
	private DLink last ; // refer to last item
	public DLList(){ // constructor
		first = null ; // no items on the list yet
     	last = null;
	}
	public boolean isEmpty(){ // true if no links are available
	return	first ==null;
	}
	public void insertFirst(double dd){ // insert at the front of the list
		DLink newLink = new DLink(dd); // make a new link
		if (isEmpty()) // if the list is empty
			last = newLink; // newLink <----- last
		else 
			first.previous = newLink; // newLink <------ old first
		newLink.next = first; // newLink ----> old first
		first = newLink; // first -----> newLink
	}
	public void insertLast(double dd){ // insert at the end of the list
		DLink newLink = new DLink(dd); // make a new link
		if (isEmpty()) // if the list is empty
			first = newLink; // newLink <----- last
		else {
			last.next = newLink; // old last -----> newLink
		newLink.previous = last; // old last <----- newLink
		}
		last = newLink; // newlink <---- last
	}
	public DLink deleteFirst(){ // assumes that the list is not empty
		DLink temp  = first; 
		if (first.next == null ) // if there's only one item on the list
			last  = null; //null <----- last
		else 
			first.next.previous = null ; // null <---- old next
		first = first.next; // first ---> old next
		return temp;
	}
	public DLink deleteLast() { // delete the last link
		// assumes the list is not  empty
		DLink temp  = last; 
		if (first.next == null ) // if there's only one item on the list
			first  = null; //first -----> null
		else 
			last.previous.next = null ; // old previous ------> null
	last = last.previous; // old previous <------ last
		return temp;
	}
	// insert dd just after key
	public boolean insertAfter (double key, double dd){ // assumes that this is not an empty list
		DLink current = first; // start at the beggining of the list
		while (current.dData != key) {// until the match is found
			current = current.next; // move to next link
			if (current == null)
				return false; // did'nt find it
		}	
		DLink newLink = new DLink(dd); // make a new Link
		if (current == last){// if its the last link
			newLink.next = null; //  newLink <---- null
			last = newLink; // newLink <---- last
		}
		else {// not the last link
			newLink.next = current.next; // newLink ----> old next
			// newLink <---- old next
			current.next.previous = newLink;
		}
		newLink.previous = current; //old current <----- newlink
		current.next = newLink; // old current ----> newLink
		return true; // found it and did the insertion
	}
	public DLink deleteKey(double key){ // delete the data item with the given key from the list
		// assumes that the list is not empty
		DLink current  = first ; // start at the begining
		while (current.dData != key) {// until the match is found
			current = current.next; // move to next link
			if (current == null)
				return null; // did'nt find it
		}	
		if (current == first){// found it first item?
			first = current.next; // first ----->  old next
		}
		else // not first
			// old previous ----> old next
			current.previous.next = current.next;
		if (current  == last) // last item?
		last  = current.previous; // old previous <----- last
		else // not last
			// old previous <----- old next
			current.next.previous = current.previous;
		return current; // return value
	}
	public void displayFoward(){
		System.out.print("List(First -----> last):");
		DLink current  = first; // start at the beginning
		while (current != null){// until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next link
			System.out.println("");
	}
	}
	public void displayBackward(){
		System.out.print("List(Last -----> first):");
		DLink current  = last; // start at the end
		while (current != null){// until the start of the list
			current.displayLink(); // print the data
			current = current.previous; // move to the previous link
			System.out.println("");
	}
	}
} // end class DLList
public class DoublyLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
DLList dList = new DLList();
dList.insertFirst(4745); // insert at the front
dList.insertFirst(979);
dList.insertFirst(294);
dList.insertFirst(349);
dList.insertLast(8594); // insert at the rear
dList.insertLast(878);
dList.insertLast(2102);
dList.insertLast(609);
dList.insertLast(456);
dList.insertLast(398);
dList.insertLast(904);
dList.displayFoward(); // display the list forward
dList.displayBackward(); // display the list backward
dList.deleteFirst(); // delete the first item
dList.deleteLast(); // delete the last item
dList.deleteKey(2102); // delete the data item with the key 2102
dList.displayFoward(); // display the list forward
dList.insertAfter(456, 7565); // insert 7565 after 456
dList.insertAfter(878, 902); // insert 902 after 878
dList.displayFoward(); // display the list forward
	}// end main
}// end class DoublyLinkedList
