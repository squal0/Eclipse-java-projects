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
class Edge{
	public int sVert; // index of a vertex starting edge
	public int eVert; // index of a vertex ending edge
	public int distance; // distance from start to end
	public Edge(int sv, int ev,int d){ // constructor
	sVert = sv;
	eVert = ev;
	distance = d;
	}
} // end class edge
class PriorityQueue{
	// array in sorted order, from max at 0 to min at size-1
	private final int SIZE = 20;
	private Edge[] queArray;
	private int size;
	public PriorityQueue(){ // constructor
		queArray = new Edge[SIZE];
		size = 0; 
	}
	public void insert(Edge item){ // insert item in sorted order
		int j;
		for(j=0; j< size; j++) // find a place to insert
			if(item.distance >= queArray[j].distance)
				break;
			for(int k = size - 1; k>= j; k--)// move items up
				queArray[k+1] = queArray[k];
			queArray[j] = item; // insert item
			size++;
		}
		public Edge removeMin(){ // remove minimum item
			return queArray[--size];
		}
		public void removeN(int n){ // remove minimum item
		for (int j = n; j< size-1; j++) // move items down
			queArray[j] = queArray[j+1];
		size--;
		}
		public Edge peekMin(){ // peek at minimum item
			return queArray[size - 1];
		}
		public int size(){
			return size;
		}
		public boolean isEmpty(){
			return (size == 0);
		}
		public Edge peekN(int n){ // peek at item n
			return queArray[n];
		}
		public int find(int findDex){ // find item with specified
			//eVert value
			for(int j = 0; j< size; j++)
				if(queArray[j].eVert == findDex)
					return j;
			return -1;
		}
	} // end class priority queue
class Vertex4{
	public char label; // the label e.g 'A'
	public boolean isInTree;
	public Vertex4(char lab){ // constructor
		label = lab;
		isInTree = false;
	}
} // end class Vertex
 class Graph4{
	 private final int MAX_VERTS = 20;
	 private final int INFINITY = 1000000000;
		private Vertex4 vertexList[]; // the list of all the vertices
		private int adjMat[][]; // field for the adjacency matrix
		private int nVertices; // current number of vertices
		private int currentVertex;
		private PriorityQueue PQ;
		private int nTree; // number of vertices in tree
		public Graph4(){ // constructor
			vertexList = new Vertex4[MAX_VERTS];
			// the adjacency matrix
			adjMat = new int [MAX_VERTS][MAX_VERTS];
			nVertices  = 0;
			for(int j=0; j<MAX_VERTS; j++) // set the adjacency
				for (int k = 0; k< MAX_VERTS; k++) // matrix to 0
					adjMat [j][k] = INFINITY;
			PQ = new PriorityQueue();
		} // end of constructor
		public void addVertex(char lab){
			vertexList [nVertices++] = new Vertex4(lab);
		}
		public void addEdge(int start , int end, int weight){
			adjMat[start][end]= weight;
			adjMat[end] [start] = weight;
		}
	public void displayVertex(int v){
		System.out.print(vertexList[v].label);
	} 
	public void mstw(){ // weighted minimum spanning tree
		currentVertex = 0 ; // start at 0
		while(nTree < nVertices - 1){ // while not all vertices in the tree
			// put the current vertex in tree
			vertexList[currentVertex].isInTree = true;
			nTree++;
			// insert edges adjacent to current vertex into PQ
			for (int j = 0; j< nVertices; j++){ // for each vertex
				if(j== currentVertex) // skip if it's us
				continue;	
				if(vertexList[j].isInTree) // skip if in the tree
					continue;
				int distance = adjMat[currentVertex][j];
				if(distance == INFINITY) // skip if no edge
					continue;
				putInPQ(j , distance); // put in the priority queue
			}
			if(PQ.size()== 0){
			System.out.println("GRAPH NOT CONNECTED");
			return;
		} 
		// remove edge with minimum distance from the priority queue
		Edge mEdge = PQ.removeMin();
		int sourceVert = mEdge.sVert;
		currentVertex = mEdge.eVert;
		// display edge from source to current
		System.out.print(vertexList[sourceVert].label);
		System.out.print(vertexList[currentVertex].label);
		System.out.print(" ");
	
	} // end while (not all vertices are in the tree)
	// mstw is complete
	for (int j = 0; j<nVertices; j++) // unmark vertices
		vertexList[j].isInTree = false;
 }// end mstw()
	public void putInPQ(int newVert, int  newDist){
		// is there another edge with the same destination vertex?7
		int queueIndex = PQ.find(newVert);
		if(queueIndex != -1){ // got edge's index
			Edge tempEdge = PQ.peekN(queueIndex); // get edge
			int oldDist = tempEdge.distance;
			if(oldDist > newDist){ // if new edge shorter
				PQ.removeN(queueIndex); // remove old edge
				Edge theEdge = new Edge(currentVertex , newVert, newDist);
				PQ.insert(theEdge); // insert new edge
			}
		} // end putInPQ()
	}
 } // end class graph
public class WeightedMST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
Graph4 iGraph = new Graph4();
iGraph.addVertex('A'); // 0 (start for mst)
iGraph.addVertex('B'); // 1
iGraph.addVertex('C'); // 2
iGraph.addVertex('D'); // 3
iGraph.addVertex('E'); // 4
iGraph.addVertex('F'); // 5
iGraph.addEdge(0, 1, 6); // AB 6
iGraph.addEdge(0, 3, 4); // AD 4
iGraph.addEdge(1, 2, 10); // BC 10
iGraph.addEdge(1, 3, 7); // BD 7
iGraph.addEdge(1, 4, 7); // BE 7
iGraph.addEdge(2, 3, 8); // CD 8
iGraph.addEdge(2, 4, 5); // CE 5
iGraph.addEdge(2, 5, 6); // CF 6
iGraph.addEdge(3, 4, 12); // DE 12
iGraph.addEdge(4, 5, 7); // EF 7
System.out.print("Minimum Spanning Tree:");
iGraph.mstw(); // minimum spanning tree
System.out.println();
	} // end main()

} // end class WeightedMST
