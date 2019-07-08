/**
 * 
 */

/**
 * @author Oracion Seis
 *The following program implements a linked list as a data structure
 */
import javax.swing.*;
class LLink{
public int inData; // data item(key)
public double dData; // data item
public LLink next; //the next link in the list

public LLink(int id, double dd){ // constructor
inData = id;
dData = dd;
}
public void displayLink(){ // display the link itself
JOptionPane.showMessageDialog(null,"{"+ inData + ","+ dData +"}");
}
}// end class link
class LinkList{
	private LLink first; // refer to the first link on the list
	public LinkList(){ // constructor
		first = null; // no links on the list yet
	}
	public void insert(int id, double dd){ // make a new link
		LLink newLink = new LLink(id, dd);
		newLink.next= first; // points to the old first link
		first = newLink; // now first points to this
	}
	public LLink find(int key){ // find the link with the given key
		// assumes that the link is not empty
		LLink current = first; // start at  first
		while(current.inData != key){ // while there's no match
			if(current.next==null)// if end of the list
				return null; // didn't find it
			else // when its not the end of the list
				current = current.next; // go to the next link
		}
		return current; // found it
	}
	public LLink delete(int key){ // delete the link with the given key
		LLink current = first; // start at  first
		LLink previous = first;
		while(current.inData != key){ // while there's no match
			if(current.next==null)// if end of the list
				return null; // didn't find it
			else // when its not the end of the list
				previous = current.next; // go to the next link
			current = current.next;
		}
		if (current == first) // if its the first link
			first = first.next; // change first
		else // otherwise
			previous.next = current.next; // bypass it
		return current; // found it	
	}
	public void displayList(){ // display the list
		JOptionPane.showMessageDialog(null, "List (First ------> last):");
		LLink current  = first; // start at the beggining of the list
		while (current != null){ // until the end of the list
			current.displayLink(); // print the data
			current = current.next; // move to the next list
		}
	}///
}// end class LinkList
public class List {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
LinkList aList = new LinkList(); // make the list
aList.insert(355, 575.00); // insert items to the new list
aList.insert(355, 575.00);
aList.insert(66557, 95.234);
aList.insert(901, 129.37);
aList.insert(899, 9293.1);
aList.insert(454, 768.20);
aList.insert(355, 354.67);
aList.displayList(); // display the list
LLink f = aList.find(388); // find the item with the given key
if(f !=null)
	JOptionPane.showMessageDialog(null,"Found the link with key"+ f.inData);
else
	JOptionPane.showMessageDialog(null, "Can't find the link");
LLink d = aList.delete	(355);
if(d !=null)
	JOptionPane.showMessageDialog(null,"Deleted the link with key"+ d.inData);
else
	JOptionPane.showMessageDialog(null, "Can't delete the link");
aList.displayList(); // display the list again
}// end main method

}// end class List
