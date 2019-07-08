/**
 * 
 */

/**
 * @author oracion seis
 * the following program demonstrates the use of iterators on a linked list
 * the program allows for various functions once the program is running
 *
 */
import java.io.*;
class Link{
	public double dData; // the data item
	public Link next; // reference to the next link in the list
	public Link(double dd){
		dData = dd;
	}
	public void displayLink(){ // display the link
		System.out.print(dData + " ");
	}
} // end class link
class LinkList{
	private Link first; // reference to the first item on the link list
	public LinkList(){// constructor
		first = null; // no items on the list yet
	}
	public Link getFirst(){ //get the value of the first
		return first;
	}
	public void setFirst(Link f){ // set first to the new link
		first = f;
	}
	public boolean isEmpty(){ // true if the list is empty
		return first == null;
	}
	public ListIterator getIterator(){ // return iterator
		return new ListIterator(this); // initialized with this list
	}
	public void displayList(){
		Link current = first; // start at the beggining of the list
		while (current != null){ // until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next link
		}
		System.out.println(" ");
	}
} // end class LinkList
class ListIterator {
	private Link current; // current Link
	private Link previous; // previous Link 
	private LinkList theList; // the Linked Liat
	public ListIterator(LinkList list) { // constructor
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
	public Link getCurrent(){ // get the current Link
		return current;
	}
	public void insertAfter(double dd){ // insert after current link
		Link newLink = new Link(dd);
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
		Link newLink = new Link(dd);
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
public class Iterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
LinkList aList  = new LinkList(); // make a new List
ListIterator iter = aList.getIterator(); // new iter
double value;
iter.insertAfter(57576); // insert items
iter.insertAfter(9797);
iter.insertAfter(4153);
iter.insertAfter(203);
iter.insertAfter(3039);
iter.insertAfter(292);
iter.insertAfter(182);
iter.insertAfter(9697);
iter.insertAfter(1023);
iter.insertAfter(782);
while(true){
	System.out.println("Enter first letter of show, reset");
	System.out.print("next, get, before, after, delete: ");
	System.out.flush();
	int choice = getChar(); // get the user's option
	switch(choice){
	case 's': // show the list
	if(!aList.isEmpty())
		aList.displayList();
	else 
		System.out.println("List is empty");
	break;
	case 'r': // reset the list(to the first)
		iter.reset();
		break;
	case 'n': // advance to the next item
		if(!aList.isEmpty() && iter.atEnd())
			iter.nextLink();
		else 
			System.out.println("Can't go to the next link");
		break;
	case 'g': // get current item
		if(aList.isEmpty()){
			value = iter.getCurrent().dData;
			System.out.println("Returned "+ value);
		}
		else 
			System.out.println("List is empty");
		break;
	case 'b': // insert before current
		System.out.print("Enter value to insert: ");
		System.out.flush();
		value = getInt();
		iter.insertBefore(value);
		break;
	case 'a': // insert after current value
		System.out.print("Enter value to insert: ");
		System.out.flush();
		value  = getInt();
		iter.insertAfter(value);
		break;
	case 'd': // delete current item
		if(!aList.isEmpty()){
			value = iter.deleteCurrent();
			System.out.println("Deleted "+ value);
		}
		else 
			System.out.println("Can't delete ");
		break;
		default:
			System.out.println("Invalid Entry ");
		
	}// end switch
}// end while
	}// end main
public static String getString() throws IOException{
	InputStreamReader word  = new InputStreamReader(System.in);
	BufferedReader sent  = new BufferedReader(word);
	String s  = sent.readLine();
	return s;
}
public static int getChar()throws IOException{
	String s  = getString();
	return s.charAt(0);
}
public static int getInt()throws IOException{
	String s  = getString();
	return Integer.parseInt(s);
} // end getInt()
}// end class Iterator
