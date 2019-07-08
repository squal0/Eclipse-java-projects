/**
 * 
 */
package graphs;

/**
 * @author Oracion Seis
 * the following program demonstrates the shortest path possible path in a weighted directed graph
 *it uses the dijkstra's algorithm to do this 
 *
 */
class DistPar{ // class distance and parent combined
	// items stored in the sPath array
	public int distance; // distance from the start to this vertex
	public int parentVert; // current parent of this vertex
	public DistPar(int pv, int d){ // constructor
	distance  = d;
	parentVert = pv;
	}
} // end class DistPar
class Vertex5{
	public char label; // the label e.g 'A'
	public boolean isInTree;
	public Vertex5(char lab){ // constructor
		label = lab;
		isInTree = false;
	}
} // end class Vertex
class Graph5{
	 private final int MAX_VERTS = 20;
	 private final int INFINITY = 1000000000;
		private Vertex5 vertexList[]; // the list of all the vertices
		private int adjMat[][]; // field for the adjacency matrix
		private int nVertices; // current number of vertices
		private int currentVertex;
		private DistPar sPath[]; // array for the shortest path data
		private int nTree; // number of vertices in tree
		private int startToCurrent; // distance to current vertex
		public Graph5(){ // constructor
			vertexList = new Vertex5[MAX_VERTS];
			// the adjacency matrix
			adjMat = new int [MAX_VERTS][MAX_VERTS];
			nVertices  = 0;
			for(int j=0; j<MAX_VERTS; j++) // set the adjacency
				for (int k = 0; k< MAX_VERTS; k++) // matrix to 0
					adjMat [j][k] = INFINITY;
			sPath = new DistPar[MAX_VERTS]; // shortest paths 
		} // end of constructor
		public void addVertex(char lab){
			vertexList [nVertices++] = new Vertex5(lab);
		}
		public void addEdge(int start , int end, int weight){
			adjMat[start][end]= weight; // directed
		}
		public void path(){ // find all the shortest paths
			int startTree = 0; // start at vertex 0
			vertexList[startTree].isInTree = true;
			nTree = 1; // put it in the tree
			// transfer  the row of distances from adjMat to sPath
			for(int j = 0; j < nVertices; j++){
				int tempDist = adjMat[startTree][j];
				sPath[j] = new DistPar(startTree, tempDist);
			}
			// until all the vertices are in the tree
			while (nTree < nVertices){
				int indexMin = getMin(); // get minimum from sPath
				int minDist = sPath[indexMin].distance;
				if (minDist == INFINITY){ // if all are infinite
					//or in tree
					System.out.println("Unreacheable Vertices:");
					break;
					//sPath is complete
				}
				else{ // reset currentVert
					currentVertex = indexMin; // to closest vertex
					startToCurrent = sPath[indexMin].distance;
					// minimum distance from start tree is
					// to currentVertex , and is ti startCurrent
				}
				// put the current vertex in tree
				vertexList[currentVertex].isInTree = true;
				nTree++;
				adjust_sPath(); // update sPath[] array
			} // end while( nTree < nVerts)
			displayPaths(); // display sPath[] contents
			nTree = 0; // clear the tree
			for(int j=0; j< nVertices; j++)
				vertexList[j].isInTree = false;	
		} // end path()
		public int getMin(){ // get entry from sPath
			// with minimum distance
			int minDist = INFINITY; // assume minimum
			int indexMin = 0;
			for(int j =1; j< nVertices; j++){ // for each vertex,
				// if it's in tree and 
				if(!vertexList[j].isInTree &&  // smaller than the old one 
						sPath[j].distance < minDist){
					minDist = sPath[j].distance;
					indexMin = j; //update the minimum
				}
			}
			return indexMin; // return the index of the minimum
		}
		public void adjust_sPath(){
			// adjust the values from the shortest path array sPath
			int column = 1 ; // skip the starting vertex
			while (column < nVertices){ // go across columns
				// if this column's vertex already in the tree, skip it
				if(vertexList[column].isInTree){
					column++;
					continue;
				}
				// calculate distance for one sPath entry
				//get edge from currentVertex to column
				int currentToFringe = adjMat[currentVertex][column];
				// add distance from start
				int startToFringe = startToCurrent + currentToFringe;
				// get distance of current sPath entry
				int sPathDist = sPath[column].distance;
				// compare distance from start with sPath entry
				if(startToFringe < sPathDist){ // if shorter
					// update sPath
					sPath[column].parentVert = currentVertex;
					sPath[column].distance = startToFringe;
				}
				column++;
			} // end while(column < nVertices)
		} // end adjust_sPath()
		public void displayPaths(){
			for(int j = 0; j < nVertices; j++){ // display all the contents of sPath[]
				System.out.print(vertexList[j].label + "="); // B=
				if(sPath[j].distance == INFINITY)
					System.out.print("inf"); // inf
				else
					System.out.print(sPath[j].distance); // 50
				char parent = vertexList[sPath[j].parentVert].label;
				System.out.print("(" + parent + ")");
				System.out.println("");
			}
		}
}
public class DijkstraAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph5 iGraph = new Graph5();
		iGraph.addVertex('A'); // 0 (start for mst)
		iGraph.addVertex('B'); // 1
		iGraph.addVertex('C'); // 2
		iGraph.addVertex('D'); // 3
		iGraph.addVertex('E'); // 4
		iGraph.addVertex('F'); // 5
		iGraph.addEdge(0, 1, 50); // AB 50
		iGraph.addEdge(0, 3, 80); // AD 80
		iGraph.addEdge(1, 2, 60); // BC 60
		iGraph.addEdge(1, 3, 90); // BD 90
		iGraph.addEdge(2, 4, 40); // CE 40
		iGraph.addEdge(3, 2, 20); // DC 20
		iGraph.addEdge(3, 4, 70); // DE 70
		iGraph.addEdge(4,1,50); // EB 50
		System.out.print("Minimum Spanning Tree:");
		iGraph.path(); // shortest paths
		System.out.println();
			} // end main()

		} // end class DijkstraAlgorihtm
