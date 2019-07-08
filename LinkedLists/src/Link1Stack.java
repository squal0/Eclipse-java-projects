import java.io.IOException;

/**
 * 
 */

/**
 * @author Oracion Seis
 * the following program uses implements a stack using a Linked List
 *It shows how a stack is an ADT and how it can be implemented with a Link1ed list
 *One might say this prgram's insertion and deletion is faster compared to when one is using an array to implement a stack
 *Here insertion and deletion takes place in O(1) time.
 */
class Link1{
	public double dData; // data item
	public Link1 next; // the next Link1 in the list
	public Link1(double dd){ // constructor
		dData = dd;
	}
	public void displayLink1(){
		System.out.print(dData + "");
	}
}
class Link1List{
	private Link1 first; // reference to the first Link1
	public Link1List(){ // constructor
		first = null; // no Link1s yet
	}
	public boolean isEmpty(){ // true if no Link1s exist
		return first == null;
	}
	public void insertFirst(double dd){ // insert at the front of the list
		Link1 newLink1 = new Link1(dd); // make a new Link1
		newLink1.next = first; // newLink1 ------> old first
		first = newLink1; // first ------> newLink1
	}
	public double deleteFirst(){ // delete the first Link1
		// assumes that the list is non-empty
		Link1 temp = first; // save the refrence to the Link1 temporarily	
		first  = first.next; // first ------> old next
		return temp.dData; // return  the deleted Link1
	}
	public void displayList(){ 
		Link1 current  = first; // start at the beginning
		while (current != null){// until the end of the list
			current.displayLink1(); // print the data
			current = current.next; // move to the next Link1
			System.out.println("");
		}
	}
	} // end class Link1 List
	class StackLink1{ 
		private Link1List aList;
		public StackLink1(){ // constructor
			aList = new Link1List();		
		}
		public void push(double j){ // put an item on top the stack
			aList.insertFirst(j);
		}
		public double pop(){ // take the item that is on top of the stack 
			return aList.deleteFirst();
		}
		public boolean isEmpty(){ // true when the stack is empty
			return( aList.isEmpty());
		}
		public void displayStack(){ // display the stack
			System.out.print("Stack (top ----> bottom):");
			aList.displayList();
		}
	}
public class Link1Stack {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
StackLink1 aStack = new StackLink1(); // make the stack
aStack.push(4757); // insert or push items into the stack
aStack.push(868);
aStack.push(155);
aStack.push(587);
aStack.push(976);
aStack.displayStack(); // display the stack
aStack.push(907);// push more items into the stack
aStack.push(757);
aStack.push(898);
aStack.push(204);
aStack.displayStack(); // display the stack after adding more items
aStack.pop(); // pop or remove items from the stack
aStack.pop();
aStack.pop();
aStack.pop();
aStack.displayStack(); // display the stack after popping the items
	}//end main()

}// end class Link1Stack

