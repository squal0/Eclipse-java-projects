/**
 * 
 */
package trees;

/**
 * @author oracion seis
 *the following program displays a binary tree
 *trees are more efficient compared to data structures like lists stacks and arrays
 *they offer fast insertion, finding and deletion
 */
import java.io.*; // for I/O operations 
import java.util.*; // for stack class
import java.lang.Integer; // for parse int()

class Node{
	public int iData; //  data item(key)
	public double dData; //  data item
	public Node leftChild ; // the node's left child
	public Node rightChild; // the  node's right child
	public void displayNode(){ //display the contents 
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print('}');
	}
}

class Tree{
	private Node root; // first node of the tree
	public Tree(){
		root  = null; // no nodes in the tree yet
	}
	public Node find(int key){ /// find the node with the given key
		Node current  = root; // start at the root 
		while (current.iData != key){ // while there's no match
		if(key< current.iData) // go left?
			current = current.leftChild;
		else // or go right
			current  = current.rightChild;
		if (current  == null) // if no child 
			return null; // did'nt find it
		}
		return current; // found it
	}
	 public void  insert (int id , double dd){
		 Node newNode  = new Node(); // make a new node
		 newNode.iData = id;
		 newNode.dData = dd;
		 if(root  == null) // no node in the root
			 root  = newNode;
		 else { // root occupied 
			 Node  current  = root; // start at the root
			 Node parent;
			 while (true){ //  exists internally
				 parent = current;
				 if(id< current.iData){ // go left?
					 current  = current.leftChild;
					 if (current  == null){ // if it's the end of the line
						 // insert  on the left
						 parent.leftChild = newNode;
						 return;
					 }
				 }
				 else{  // or go right
					 current  = current.rightChild;;
					 if(current == null){ // if the end  of the line
						 parent.rightChild = newNode;
						 return;
					 }
				 }
			 }
		 }
	 }
	 public boolean delete(int key){ // delete the node with the given key
		 // assumes this is a non empty tree
		 Node current = root;
		 Node  parent = root;
		 boolean isLeftChild  = true;
		 while(current.iData != key){  // search for the item
			 parent  = current;
			 if (key < current.iData){ // go left?
				 isLeftChild  = true;
				 current  = current.leftChild;
			 }
			 else{ // or go right
				 isLeftChild  = false;
 current  = current.rightChild;		
			 }
			 if (current  == null) // end of the line
			return false; // did'nt find it	 
		 }
		 // found the node to delete
		 // if nod has no children simply delete it
		 if(current .leftChild == null && current.rightChild == null){
			 if ( current  == root ) // if root
				 root  = current.leftChild; // tree is empty
				 else if(isLeftChild)
					 parent.leftChild = null; // disconnect
				 else // from parent
					 parent.rightChild = null;
		 }
		 // if no right child replace with left sub tree
		 else if(current.rightChild == null)
			 if (current == root)
				 root = current.leftChild;
			 else if (isLeftChild)
				 parent.leftChild = current.leftChild;
		 // if no left child replace with right sub tree
			 else if(current.leftChild == null)
				 if (current == root)
					 root = current.rightChild;
				 else if(isLeftChild)
					 parent.leftChild = current.rightChild;
				 else 
					 parent.rightChild = current.rightChild;
			 else { /// two children, thus replace with inorder successor
				 // get the successor of node to delete (current)
				 Node successor  = getSuccessor(current);
				 // connect parent of current node to successor instead
				 if(current == root)
					 root  = successor;
				 else if (isLeftChild)
					 parent.leftChild = successor;
				 else 
					 parent.rightChild = successor;
				 // connect successor to current node's left child
				 successor.leftChild = current.leftChild;
			 } // end else 2 children
		 /* successor cannot have a left child..... if this was to happen then 
		  * the successor's left child becomes the successor
		  */
		 return true; // deleting a success
	 }
	 /*returns the node wiht next highest value after the deleted Node
	  * goes to the right child , then the right child's left descendants
	  */
	 private Node getSuccessor(Node delNode){
		 Node successorParent = delNode;
		 Node successor = delNode;
		 Node current  = delNode.rightChild ; // go to right child
		 while(current != null){ // until no more
			 // left children
			 successorParent  = successor;
			 successor  = current;
			 current  = current.leftChild; // go to the left child
		 }
		 // if not successor
		 if(successor != delNode.rightChild){ //  right child
			 // make connections
			 successorParent.leftChild = successor.rightChild;
			 successor.rightChild = delNode.rightChild;
		 }
		 return successor;
	 }
	 public void displayTree(){
		 Stack<Node> globalStack = new Stack<Node>();
		 globalStack.push(root);
		 int nBlanks = 32;
		 boolean isRowEmpty  = false;
		 System.out.println(".......................................................");
		 while( isRowEmpty  == false){
			 Stack<Node> localStack = new Stack<Node>();
			 isRowEmpty = true;
			 for(int j = 0; j < nBlanks; j++)
				 System.out.print("  ");
			 while( globalStack.isEmpty() == false){
				 Node temp = (Node)globalStack.pop();
				 if(temp != null){
					 System.out.print(temp.iData);
					 localStack.push(temp.leftChild);
					 localStack.push(temp.rightChild);
					 
					 if(temp.leftChild != null || temp.rightChild != null)
						 isRowEmpty  = false;
				 }
				 else {
					 System.out.print("___");
					 localStack.push(null);
					 localStack.push(null);
				 }
				 for(int j = 0; j < nBlanks*2 -2; j++ )
					 System.out.print("  ");
			 }
			 System.out.println();
			 nBlanks /=2;
			 while(localStack.isEmpty() == false)
				 globalStack.push(localStack.pop());
		 }
		 System.out.println("........................................................");
	 }
}
public class BinarySearchTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
int value;
Tree aTree = new Tree();
aTree.insert(4858, 6897.79);
aTree.insert(9758, 1897.4);
aTree.insert(78, 5757.23);
aTree.insert(6161, 321.79);
aTree.insert(5729, 68122.52);
aTree.insert(7686, 2552.68);
aTree.insert(369, 300.9);
aTree.insert(127 , 5903.36);
aTree.insert(685, 302.21);
aTree.insert(379, 00.0);
aTree.insert(49, 292.70);
aTree.insert(4948 , 8485.201);
aTree.insert(256,764.387);
aTree.insert(36336, 6234.38);
aTree.insert(157, 912.034);
aTree.insert(2671, 3737.90);
aTree.insert(88594 ,940.23);
aTree.insert(1661, 7808.73);
aTree.insert(3646, 965.55);
aTree.insert(46457, 756.96);
aTree.insert(69 ,96.69);
aTree.insert(4858, 5858.333);

while (true){
	putText("Enter first letter of ");
	putText("Show, insert, find and delete:");
	int choice  = getChar();
	switch(choice){
	case 's':
		aTree.displayTree();
		break;
	case 'i':
		putText("Enter value to insert: ");
		value = getInt();
		aTree.insert(value, value + 557.86);
		break;
	case 'f':
		putText("Enter the value to be found: ");
		value = getInt();
		Node found  = aTree.find(value);
		if(found != null){
			putText("Value Found....");
			found.displayNode();
			putText("\n");
		}
		else 
			putText("Could not find the item with the value "+ value + '\n');
		break;
	case 'd':
		putText("Enter the value to delete: ");
		value = getInt();
		boolean didDelete = aTree.delete(value);
		if(didDelete)
			putText("Deleted "+ value + '\n');
		else 
			putText("Could not delete "+ value+ '\n');
		break;
		default:
			putText("Invalid Entry please try again");
	}
}
	}
	public static void putText(String s)
	{
	System.out.print(s);
	System.out.flush();
	}
	// −−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
	public static String getString() throws IOException
	{
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String s = br.readLine();
	return s;
	}
	// −−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
	public static char getChar() throws IOException
	{
	String s = getString();
	return s.charAt(0);
	}
	// −−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−−
	public static int getInt() throws IOException
	{
	String s = getString();
	return Integer.parseInt(s);
	}
}
