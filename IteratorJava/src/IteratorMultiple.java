/**
 * 
 */

/**
 * @author oracion seis
 * the following program demonstrates the use of an iterator 
 * this program by delete any data item with a key that is either divisible by 3 or 4
 * it is similar to the first iterator program the only thing that changes is the main code
 *
 */
import java.io.*;
class Link1{
	public double dData; // the data item
	public Link1 next; // reference to the next link in the list
	public Link1(double dd){
		dData = dd;
	}
	public void displayLink(){ // display the link
		System.out.println(dData + " ");
	}
} // end class link1
class LinkList1{
	private Link1 first; // reference to the first item on the link list
	public LinkList1(){// constructor
		first = null; // no items on the list yet
	}
	public Link1 getFirst(){ //get the value of the first
		return first;
	}
	public void setFirst(Link1 f){ // set first to the new link
		first = f;
	}
	public boolean isEmpty(){ // true if the list is empty
		return first == null;
	}
	public ListIter getIterator(){ // return iterator
		return new ListIter(this); // initialized with this list
	}
	public void displayList(){
		Link1 current = first; // start at the beggining of the list
		while (current != null){ // until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next link
		}
		System.out.println(" ");
	}
}// end class LinkList1
class ListIter{
	private Link1 current; // current Link
	private Link1 previous; // previous Link 
	private LinkList1 theList; // the Linked Liat
	public ListIter(LinkList1 list) { // constructor
		theList = list;
		reset();
	}
	public void reset(){ // start at first
		current = theList.getFirst();
		previous = null;
	}
	public boolean atEnd(){ // true if its the last link
		return(current.next==null);
	}
	public void nextLink(){ // go to the next link
		previous = current;
		current = current.next;
	}
	public Link1 getCurrent(){ // get the current Link
		return current;
	}
	public void insertAfter(double dd){ // insert after current link
		Link1 newLink = new Link1(dd);
		if (theList.isEmpty())// empty list
		{
		theList.setFirst(newLink);
		current  = newLink;
	}
		else { // not empty
			newLink.next = current.next;
		current.next = newLink;
		 nextLink();// point to the new Link
		}
	}
	public void insertBefore(double dd){ // insert after current link
		Link1 newLink = new Link1(dd);
		if (previous == null)// at the beginning of the list
		{// or list is empty
			newLink.next = theList.getFirst();
		theList.setFirst(newLink);
		reset();
	}
		else { // not at the beginning
			newLink.next = previous.next;
		previous.next = newLink;
		current  = newLink;
		}
	}
	public double deleteCurrent(){ // delete the item at current
		double value = current.dData;
		if(previous == null){// beginning of List
			theList.setFirst(current.next);
			reset();
		}
		else{ // not at the beginning
			previous.next = current.next;
			if(atEnd())
				reset();
			else
				current = current.next;
		}
		return value;		
	} // end class ListIterator
	
}
public class IteratorMultiple {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
LinkList1  aList = new LinkList1(); // new list
ListIter iter1  = aList.getIterator(); // new Iter
iter1.insertAfter(57576); // insert items
iter1.insertAfter(9797);
iter1.insertAfter(4153);
iter1.insertAfter(203);
iter1.insertAfter(3039);
iter1.insertAfter(292);
iter1.insertAfter(182);
iter1.insertAfter(9697);
iter1.insertAfter(1023);
iter1.insertAfter(782);
System.out.println("List before deletion");
aList.displayList(); // display the list
iter1.reset(); // start at the first link
Link1 aLink = iter1.getCurrent(); // get it
if (aLink.dData% 3==0 || aLink.dData% 4==0 ) // if divisible by 3 or 4
	iter1.deleteCurrent(); // delete it
while (!iter1.atEnd()){ // until the end of the list
	iter1.nextLink(); // go to the next link
	aLink = iter1.getCurrent(); // get it
	if (aLink.dData% 3==0 || aLink.dData% 4==0 ) // if divisible by 3 or 4
		iter1.deleteCurrent(); // delete it
}
System.out.println("List after deletion");
aList.displayList(); // display the list
	} //end main()
}// end class IteratorMultiple
