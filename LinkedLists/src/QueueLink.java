/**
 * 
 */

/**
 * @author Oracion Seis
 * the following program shows a queue implemenented as a double ended list
 *
 */
class QLink{
	public double dData; // data item
	public QLink next; // next link in the list

public QLink(double dd){ // constructor
	dData = dd;
}
public void displayLink(){ // display this link
	System.out.print(dData + "");
}
} // end class QLink
class FLList{
	private QLink first; // refer to first item
	private QLink last ; // refer to last item
	public FLList(){ // constructor
		first = null ; // no items on the list yet
		last = null;
	}
	public boolean isEmpty(){ // return true if no links are available
		return (first == null);
	}
	public void insertLast(double dd){ // insert at the end of the list
		QLink newLink = new QLink(dd); // make new Link
		if (isEmpty()) //if its an empty list
			first = newLink; // first -----> newLink
		else 
			last.next = newLink; // old last ------> newLink
		last  = newLink; // newlink <------ last
	} 
	public double deleteFirst(){ // delete the first link
		// assumes that the list is non-empty
		if(first.next == null) // if onnly one item
			last = null; // null <---- last
		first  = first.next; // first ------> old next
		return temp;
	}	double temp = first.dData; // save the data temporarily
	
	public void displayList(){ 
		System.out.print("List(First -----> last):");
		QLink current  = first; // start at the beginning
		while (current != null){// until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next link
			System.out.println("");
		}
	}
}// end class FLList
class LinkQueue{
private FLList qList;
public LinkQueue(){ // constructor
	qList  = new FLList(); // make a 2 ended list
}
public boolean isEmpty(){ // returns true if queue is empty
	return qList.isEmpty();
}
public void insert (double q){ // insert at the rear of the queue
	qList.insertLast(q);
}
public void remove(){ // remove from the front of the queue
	qList.deleteFirst();
}
public void displayQueue(){
	System.out.print("Queue (front -----> rear):");
	qList.displayList();
}
} //end class Link queue
public class QueueLink {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
LinkQueue qQueue = new LinkQueue(); // make the queue
qQueue.insert(6777); // insert items in the queue
qQueue.insert(5656);
qQueue.insert(9954);
qQueue.insert(123);
qQueue.insert(9876);
qQueue.displayQueue(); // display the queue
qQueue.insert(876);
qQueue.insert(204);
qQueue.insert(817);
qQueue.insert(277);
qQueue.displayQueue();// display again
qQueue.remove(); // remove items from the queue
qQueue.remove();
qQueue.remove();
qQueue.displayQueue(); // display after removing items from the queue
	} //end main

}// end class QueueLink
