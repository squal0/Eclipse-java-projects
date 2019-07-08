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
class Queue{
	private final int SIZE = 20;
	private int [] queArray;
	private int front;
	private int rear;
	public Queue(){ // constructor
		front  = 0;
		rear = -1;
	}
	public void insert(int j){ // put item at the rear of a queue
		if(rear == SIZE - 1 )
			rear = -1;
		queArray[++rear] = j;
	}
	public int remove(){ // take item from the front of a queue
		int temp = queArray[front++];
		if(front == SIZE)
			front  = 0;
		return temp;
	}
	public boolean isEmpty(){ // true if queue is empty
		return (rear + 1 == front || (front + SIZE -1 == rear));
	}
} // end class Queue
class Vertex1{
	public char label; // the label e.g 'A'
	public boolean wasVisited;
	public Vertex1(char lab){ // constructor
		label = lab;
		wasVisited = false;
	}
} // end class Vertex
class Graph1{
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // the list of all the vertices
	private int adjMat[][]; // field for the adjacency matrix
	private int nVertices; // current number of vertices
	private Queue iQueue;
	public Graph1(){ // constructor
		vertexList = new Vertex[MAX_VERTS];
		// the adjacency matrix
		adjMat = new int [MAX_VERTS][MAX_VERTS];
		nVertices  = 0;
		for(int j=0; j<MAX_VERTS; j++) // set the adjacency
			for (int k = 0; k< MAX_VERTS; k++) // matrix to 0
				adjMat [j][k] = 0;
		iQueue = new Queue();
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
public void bfs(){ // breadth first search method
	// begin at vertex 0
		vertexList[0].wasVisited = true; // mark it
		displayVertex(0); // display it
		iQueue.insert(0); // insert at tail
		int v2;
		while(!iQueue.isEmpty()){ // until the queue is empty
			int v1 = iQueue.remove(); // remove vertex at head of the queue
			// until no unvisited neighbours
			while((v2 = getAdjUnvisitedVertex(v1)) != 1){
				// get one
				vertexList[v2].wasVisited = true; // mark it
				displayVertex(v2); // display it
				iQueue.insert(v2); // insert it
			} // end while
		}// end while (queue not empty)
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
public class BfsGraph {

	/**
	 * @param args
	 * the program here demonstrates the a graph using the breadth first search
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph1 iGraph = new Graph1(); // create a new Graph
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
		iGraph.bfs(); // breadth first search
		System.out.println();
			} // end main()
		} // end class dfsGraph
