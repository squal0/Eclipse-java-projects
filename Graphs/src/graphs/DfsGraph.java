/**
 * 
 */
package graphs;

/**
 * @author Squalo
 *
 */
import java.awt.*;
@SuppressWarnings("unused")
class StackG{
	private final int SIZE = 20;
	private int [] st;
	private int top;
	public StackG(){ // constructor
		st = new int [SIZE]; // make the array
		top = -1;
	}
	public void push(int j){ // push the items on the stack
		st[++top] = j;
	}
	public int pop(){ // take the items of the stack
		return st[top--];
	}
	public int peek(){ // peek to see the item on top of the stack
		return st[top];
	}
	public boolean isEmpty(){ // return true if nothing is on the stack
		return(top == -1);
	}
} // end class StackG
class Vertex{
	public char label; // the label e.g 'A'
	public boolean wasVisited;
	public Vertex(char lab){ // constructor
		label = lab;
		wasVisited = false;
	}
} // end class Vertex
class Graph{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // the list of all the vertices
	private int adjMat[][]; // field for the adjacency matrix
	private int nVertices; // current number of vertices
	private StackG iStack;
	public Graph(){ // constructor
		vertexList = new Vertex[MAX_VERTS];
		// the adjacency matrix
		adjMat = new int [MAX_VERTS][MAX_VERTS];
		nVertices  = 0;
		for(int j=0; j<MAX_VERTS; j++) // set the adjacency
			for (int k = 0; k< MAX_VERTS; k++) // matrix to 0
				adjMat [j][k] = 0;
		iStack  = new StackG();
	} // end of constructor
	public void addVertex(char lab){
		vertexList [nVertices++] = new Vertex(lab);
	}
	public void addEdge(int start , int end){
		adjMat[start][end]= 1;
		adjMat[end] [start] = 1;
	}
public void displayVertex(int v){
	System.out.print(vertexList[v].label);
}
public void dfs(){ // depth first search method
	// begin at vertex 0
	vertexList[0].wasVisited = true; // mark it
	displayVertex(0); // display it
	iStack.push(0); // push it
	while(! iStack.isEmpty()){ // until the stack is empty
		// get an unvisited vertex adjacent to stack top
		int v = getAdjUnvisitedVertex(iStack.peek());
		if(v == -1) // if no such vertex exists
			iStack.pop();
		else{ // if it exists
			vertexList[v].wasVisited = true; // mark it
			displayVertex(v); // display it
			iStack.push(v);
		}
	} // end while
	// the stack is empty so we are done
	for (int j =0 ; j<nVertices; j++)
		 vertexList[j].wasVisited = false;
} //end dfs method
// returns an unvisited vertex adj to v
public int getAdjUnvisitedVertex(int v){
	for (int j = 0; j< nVertices; j++)
		if(adjMat[v][j]== 1 && vertexList[j].wasVisited == false)
			return j;
	return -1;
} //end getAdjUnvisitedVertex()
} // end class Graph
public class DfsGraph {

	/**
	 * @param args
	 * the following program simulates a graph that has the depth first search
	 * Graphs are data structures that are modelled according to the situation given
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph iGraph = new Graph(); // create a new Graph
iGraph.addVertex('D');
iGraph.addVertex('H');
iGraph.addVertex('J');
iGraph.addVertex('L');
iGraph.addVertex('E');
iGraph.addVertex('M');
iGraph.addVertex('Y');
iGraph.addVertex('N');
iGraph.addVertex('O');
iGraph.addVertex('Q');
iGraph.addVertex('Z');
iGraph.addVertex('F');
iGraph.addVertex('C');

iGraph.addEdge(0, 1);
iGraph.addEdge(0, 2);
iGraph.addEdge(1, 3);
iGraph.addEdge(5, 1);
iGraph.addEdge(2, 8);
iGraph.addEdge(8, 9);
iGraph.addEdge(1, 1);
iGraph.addEdge(8, 1);
iGraph.addEdge(6, 9);
iGraph.addEdge(2, 10);
iGraph.addEdge(7, 9);
System.out.print("Visits: ");
iGraph.dfs(); // depth first search
System.out.println();
	} // end main()
} // end class dfsGraph
