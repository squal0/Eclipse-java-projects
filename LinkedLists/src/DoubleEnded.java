/**
 * 
 */

/**
 * @author Oracion Seis
 * the following program shows the use of a double ended linked list
 * it is not to be confused with the doubly linked list
 *double ended linked list is similar to an ordinary linked list with one additional feature
 *that is it has a reference to the last link
 */
class Link{
	public double dData; // data item
	public Link next; // the next link in the list
	public Link(double dd){ // constructor
		dData = dd;
	}
	public void displayLink(){
		System.out.print(dData + "");
	}
}// end class link
class FirstLastList{
	private Link first; // reference to the first link
	private Link last; // refrence to the last link
	public FirstLastList(){ // constructor
		first = null; // no links yet
		last = null;
	}
	public boolean isEmpty(){ // true if no links exist
		return first == null;
	}
	public void insertFirst(double dd){ // insert at the front of the list
		Link newLink = new Link(dd); // make a new link
		if (isEmpty()) //if its an empty list
			last  = newLink; // newLink <------ Last
		newLink.next = first; // newLink ------> old first
		first = newLink; // first ------> newLink
	}
	public void insertLast(double dd){ // insert at the end of the list
		Link newLink = new Link(dd); // make new Link
		if (isEmpty()) //if its an empty list
			first = newLink; // first -----> newLink
		else 
			last.next = newLink; // old last ------> newLink
		last  = newLink; // newlink <------ last
	}
	public double deleteFirst(){ // delete the first link
		// assumes that the list is non-empty
		double temp = first.dData; // save the data temporarily
		if(first.next == null) // if onnly one item
			last = null; // null <---- last
		first  = first.next; // first ------> old next
		return temp;
	}
	public void displayList(){ 
		System.out.print("List(First -----> last):");
		Link current  = first; // start at the beginning
		while (current != null){// until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next link
			System.out.println("");
		}
			
	}
}
public class DoubleEnded {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
FirstLastList aList  = new FirstLastList();
aList.insertFirst(644); // insert at the front
aList.insertFirst(5144);
aList.insertFirst(344);
aList.insertFirst(975);
aList.insertFirst(714);
aList.insertFirst(822);
aList.insertFirst(457);
aList.insertFirst(909);
aList.insertFirst(122);
aList.insertFirst(672);
aList.insertFirst(757);
aList.insertLast(868); // insert at rear
aList.deleteFirst(); // delete the first 2 data items
aList.deleteFirst();
aList.displayList(); // display the list again after deletion
	}// end main method
}// end class DoubleEnded
