/**
 * 
 */
package multiway_trees;

/**
 * @author Oracion Seis
 *the following program demonstrates a 2-3-4 Tree commonly used in external storage
 */
import java.io.*;
import java.lang.Integer;
class DataItem{
	public double dData; // one data item
	public DataItem(double dd){ // constructor
	dData = dd;	
	}
	public void displayItem(){ // display the item  format "/DataItem"
		System.out.print("/"+ dData);
	}
}
class Node{
	private static final int ORDER = 4;
	private int numItems;
	private Node  parent;
	private Node childArray[] = new Node [ORDER];
	private DataItem itemArray[] = new DataItem[ORDER -1];
	
	// connect child to this node
	public void connectChild(int childNumber, Node child){
		childArray [childNumber]= child;
		if(child != null)
			child.parent = this;
	}
	
	// disconnect child from this node, return it
	public Node disconnectChild(int childNumber){
		Node tempNode = childArray[childNumber];
		childArray[childNumber]= null;
		return tempNode;
	}
	public Node getChild(int childNumber){
		return childArray[childNumber];
	}
	public Node getParent(){
		return parent;
	}
	public boolean isLeaf(){
		return (childArray[0] == null)? true : false;
	}
	public int getNumItems(){
		return numItems;
	}
	public DataItem getItem(int index){ // get Data item at given index
		return itemArray[index];
	}
	public boolean isFull(){
		return (numItems  == ORDER-1)? true : false;
	}
	public int findItem(double key){ // return index of item within the node
	for(int j =0; j< ORDER-1; j++){ // if found
		// other wise
		if (itemArray[j] == null) // return -1
			break;
		else if(itemArray[j].dData == key)
			return j;
	}
	return -1;
} // end findItem()
	public int insertItem(DataItem newItem){
		// assumes the node is not full
		numItems++; // will add a new item
		double newKey = newItem.dData; // key of the new item
		for (int j = ORDER-2; j>=0; j--){ // start on the right
			// examine the items
			if (itemArray[j] == null) // if item null
				continue; // go left one cell
			else{ // not null
				double iKey  = itemArray[j].dData;
				if (newKey < iKey) // if it's bigger
					itemArray[j+1] = itemArray[j]; // shift it right
				else{
					itemArray[j+1] = newItem; // insert new item
					return j+1; // return index to
				} // new item
			} // end else(not null)
		} /// end for // shifted all items
		itemArray[0] = newItem; // insert new item
		return 0;
	} // end insert item
	public DataItem removeItem(){ // remove the largest item
		// assumes the node is not  empty
		DataItem temp = itemArray[numItems - 1]; // save the item
		itemArray[numItems - 1] = null ; // disconnect it
		numItems--; // one less item
		return temp; // return the item
	}
	public void displayNode(){ // format "/24/56/74"
		for(int j =0; j< numItems; j++)
			itemArray[j].displayItem(); // "/item"
		System.out.println("/"); //final "/"
	}
	} // end class Node
class Multiway{
	private Node root  = new Node (); // make root node
	
	public int find(double key){
		Node currentNode  = root;
		int  childNumber;
		while (true){
			if ((childNumber = currentNode.findItem(key))!= -1)
				return childNumber; // found it
			else if(currentNode.isLeaf())
				return -1; // can't find it
			else // search depper within the tree
				currentNode = getNextChild(currentNode, key);
		} // end while
	}
	
	// insert a data item
	public void insert (double dValue){
		Node currentNode  = root;
		DataItem tempItem = new DataItem(dValue);
		while (true){
			if(currentNode.isFull()){ // if node full
				spilt(currentNode); // split it
				currentNode = currentNode.getParent(); // back up
				// search once
				currentNode = getNextChild(currentNode , dValue);
			} // end if(node is full)
			else if(currentNode.isLeaf()) // if node is leaf
				break; // go insert
			// node is not full , not a leaf; so go to the lower level
			else
				currentNode = getNextChild(currentNode , dValue);
		} // end while
		currentNode.insertItem(tempItem); // insert new DataItem
	} // end insert()
	public void spilt(Node thisNode) { // split the node
		// TODO Auto-generated method stub
		// assumes node is Full
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;
		itemC = thisNode.removeItem(); // remove items from c
		itemB = thisNode.removeItem(); // this node
		child2 = thisNode.disconnectChild(2); // remove children
		child3 = thisNode.disconnectChild(3); // from this node
		Node newRight = new Node(); // make new node
		if(thisNode == root){ // if this is the root
			root = new Node(); // make new root
			parent  = root; // root is our parent
			root.connectChild(0, thisNode); // connect to parent
		}
		else // this node is not the root
			parent  = thisNode.getParent(); // get parent
		// deal with parent
		itemIndex  = parent.insertItem(itemB); // itemB to parent
		int n = parent.getNumItems(); // total items?
		for(int j = n-1; j> itemIndex; j--){ // move parent's connections
			Node temp = parent.disconnectChild(j); // one child
			parent.connectChild(j+1, temp); // to the right
		}
		// connect newRight to parent
		parent.connectChild(itemIndex +1, newRight);
		// deal with new right
		newRight.insertItem(itemC); // itemC to new right
		newRight.connectChild(0, child2); // connect to 0 and 1
		newRight.connectChild(1, child3); // on newRight
	} // end split ()
	// gets appropriate child of node during search for  value
	public Node getNextChild(Node aNode, double aValue) {
		// TODO Auto-generated method stub
		int j;
		// assumes node is not empty, not full , not a leaf
		int numItems = aNode.getNumItems();
		for(j =0; j< numItems; j++){// for each item in node
			// are we less?
			if(aValue < aNode.getItem(j).dData)
				return aNode.getChild(j); // return left child
		} // end for // we are greater, so
		return aNode.getChild(j); // return right child
	}
	public void displayTree(){
		recDisplayTree(root , 0, 0);
	}

	private void recDisplayTree(Node aNode, int level, int childNumber) {
		// TODO Auto-generated method stub
		System.out.print("Level= "+ level + "child= "+ childNumber +" ");
		aNode.displayNode(); // display this node
		// call ourselves for each child of this node
		int numItems  = aNode.getNumItems();
		for(int  j=0; j< numItems + 1; j++){
			Node nextNode = aNode.getChild(j);
			if(nextNode != null)
				recDisplayTree(nextNode , level +1, j);
			else 
				return;
		}
	} // end recDisplayTree()
}
public class Tree234 {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		double value;
		Multiway theTree = new Multiway();
		theTree.insert(50);
		theTree.insert(40);
		theTree.insert(60);
		theTree.insert(30);
		theTree.insert(696);
		theTree.insert(22929);
		theTree.insert(7070);
		theTree.insert(1616);
		theTree.insert(9066);
		theTree.insert(151);
		theTree.insert(264);
		theTree.insert(70);
		theTree.insert(575);
		theTree.insert(7797);
		
		while(true)
		{
		putText("Enter first letter of ");
		putText("show, insert, or find: ");
		char choice = getChar();
		switch(choice)
		{
		case 's':
		theTree.displayTree();
		break;
		case 'i':
		putText("Enter value to insert: ");
		value = getInt();
		theTree.insert(value);
		break;
		case 'f':
		putText("Enter value to find: ");
		value = getInt();
		int found = theTree.find(value);
		if(found != -1)
		System.out.println("Found "+value);
		else
		System.out.println("Could not find "+value);
		break;
		default:
		putText("Invalid entry\n");
		} // end switch
		} // end while
		} // end main()
		//−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
		public static void putText(String s)
		{
		System.out.print(s);
		System.out.flush();
		}
		//−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
		public static String getString() throws IOException
		{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
		}
		//−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
		public static char getChar() throws IOException
		{
		String s = getString();
		return s.charAt(0);
		}
		//−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
		public static int getInt() throws IOException
		{
		String s = getString();
		return Integer.parseInt(s);
		}

	}


