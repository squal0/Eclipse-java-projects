/**
 * 
 */
package graphs;

/**
 * @author Squalo
 *the following program demonstrates a topological sort
 *the sort only works when no cycles exist in the graph
 *a cycle is formed when every vertex has a successor
 */
import java.awt.*;
@SuppressWarnings("unused")
class Vertex3{
	public char label; // label eg 'A'
	public Vertex3(char lab){ // constructor
		label = lab;
	}
}
class Graph3{
	private final int MAX_VERTS = 20;
	private Vertex3 vertexList[]; // the list of all the vertices
	private int adjMat[][]; // field for the adjacency matrix
	private int nVertices; // current number of vertices
	private char sortedArray[];
	public Graph3(){ // constructor
		vertexList = new Vertex3[MAX_VERTS];
		// the adjacency matrix
		adjMat = new int [MAX_VERTS][MAX_VERTS];
		nVertices  = 0;
		for(int j=0; j<MAX_VERTS; j++) // set the adjacency
			for (int k = 0; k< MAX_VERTS; k++) // matrix to 0
				adjMat [j][k] = 0;
		sortedArray = new char [MAX_VERTS]; // sorted vert label
	}// end the constructor
	public void addVertex(char lab){
		vertexList [nVertices++] = new Vertex3(lab);
	}
	public void addEdge(int start , int end){
		adjMat[start][end]= 1;
	}
public void displayVertex(int v){
	System.out.print(vertexList[v].label);
}
public void topological(){ // topological sort method
	int orig_nVertices = nVertices; // remember how many vertices 
	while (nVertices> 0){ // while the nVertices remain
		// get a vertex with no successors or -1
		int currentVertex = noSuccessors();
		if(currentVertex == -1){ // must be a cycle
			System.out.println("ERROR! The graph has cycles");
			return;
		}
		// insert vertex label into the sorted array (Start to end)
		sortedArray[nVertices - 1] = vertexList[currentVertex].label;
		deleteVertex(currentVertex); // delete the current vertex
	} // end while
	// vertices are all gone display the sorted array
	System.out.print("Topologically sorted order:");
	for(int j =0; j<orig_nVertices; j++)
		System.out.print(sortedArray[j]);
	System.out.println(" ");
} // end the topological()
public int noSuccessors(){ // returns a vertex with no successors
	/// or - 1 if no such vertex exists
	boolean isEdge; // edge from row to column in the adjacency matrix
	for(int row = 0; row < nVertices; row++){ // for each vertex
		isEdge = false; // check edges
		for(int col = 0; col <nVertices; col++){
			if(adjMat [row][col]> 0){ // if edge to another edge
				isEdge = true;
				break; // this vertex
			} // has a successor
		}// try another
		if(!isEdge) // if no edges
			return row; // has no successors
	}
	return - 1; // no such vertex
} // end no successors()
public void deleteVertex(int deleteVert){
	if(deleteVert != nVertices -1 ){ // if not the last vertex
		//delete the vertex from the list
		for (int j = deleteVert ; j< nVertices - 1; j++)
			vertexList[j] = vertexList[j+1];
		// delete row from the adjacency matrix
		for(int row = deleteVert; row < nVertices - 1; row++)
			moveRowUp (row , nVertices);
		// delete column from the adjacency matrix
		for(int col = deleteVert; col < nVertices - 1; col++)
			moveColLeft(col, nVertices -1);
	}
	nVertices--; // one less vertex
} // end delete vertex
private void moveRowUp(int row, int length){
	for(int col = 0; col< length; col++)
		adjMat[row][col] = adjMat[row+1][col];
}
private void moveColLeft(int col, int length){
	for(int row = 0; row< length; row++)
		adjMat[row][col] = adjMat[row][col+ 1];
}
}
public class TopologicalSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph3 iGraph = new Graph3(); // create a new Graph
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
		iGraph.topological(); // topological sort
		System.out.println();
	} // end main()
} // end class Topological Sort

