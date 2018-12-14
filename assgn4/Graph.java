
import java.util.*;

public class Graph {
    final int SIZE = 97;
    public int count = 0;
    private int nextOpen = 0;

    Vertex[] table = new Vertex[SIZE];

    public Graph() {

    }
    public void insert(String town1, String town2, int distance) {
	// TODO
	int indexTown1 = find(town1);
	int indexTown2 = find(town2);
	if (indexTown1 < 0) {
		table[nextOpen] = new Vertex(town1);
		nextOpen++;
		count++;
	}
	if (indexTown2 < 0) {
		table[nextOpen] = new Vertex(town2);
		nextOpen++;
		count++;
	}
	indexTown1 = find(town1);
	indexTown2 = find(town2);
	Edge edgeTown1 = new Edge(table[indexTown1], table[indexTown2], distance);
	Edge edgeTown2 = new Edge(table[indexTown2], table[indexTown1], distance);
	table[indexTown1].addEdge(edgeTown1);
	table[indexTown2].addEdge(edgeTown2);
    }
    public int find(String town) {
    //private int find(String town) {
	    for (int i = 0; i < table.length; i++) {
		    if (table[i] != null) {
		    	if (table[i].name.equals(town)) {
			    return i;
		    	}
		    }
	    }
	    return -1;
    }



    private void buildHeap(String start, MinHeap heap) {
   	//TODO
        heap.buildHeap();
        heap.setStart(this.find(start));
    }
    
    private void showPath(String start, String finish) {
    
       //TODO
       //
       //System.out.println(first.town);
      
    }
/*
    public int minEdgeIndex(Vertex current) {
	    int min = 0;
	    for (int i = 1; current.getEdges().length; i++) {
		    if (current.getEdges()[i].distance < current.getEdges()[min].distance) {
			    min = i;
		    }
	    }
	    return min;
    }
*/
    
    public void shortestPath(String start, String finish) {
    	
    	//Create heap (Build Heap Look at heap slides) with all connecting nodes as infinity dis 
    	//While loop/for
    	//Call extract min (recursive) and return vertex. Now found start to start
    	//Update cost (recursive) of next edge to start
    	//Heapify up the new edge node
    	
    	MinHeap heap = new MinHeap(SIZE, this);
	buildHeap(start, heap);
	while (table[0].name != finish) {
		for (int i = 0; i < table[0].getEdges().length; i++) {
			// Distance initialized at infinity or preiously calculated.
			int currentDistOfAdjNodeFromStart = table[0].getEdges()[i].getVerticies()[1].distance;
			// Distance of current root node from the start of path.
			int currentDistFromStart = table[0].distance;
			// Distance from current node to adjacent node (edge distance);
			int distFromCurToAdj = table[0].getEdges()[i].distance;
			// if distance from current node to adjacent node is less than the adjacents distance from start then replace with shorter path.
			if ((currentDistFromStart + distFromCurToAdj) < currentDistOfAdjNodeFromStart) {
				// replace with new shorter path.
				table[0].getEdges()[i].getVerticies()[1].distance = currentDistFromStart + distFromCurToAdj;
			}
		}
		heap.extract();
	}
    	//Set the distances from start to all location to infinity and visited to false
    	
	/*
    	distancesFromStart[startingIndex] = 0;
    	for (int i=0; i < SIZE; i++) {
    		Edge [] edgeArr = table[startingIndex].getEdges();
    		
    	}
    	*/
    	
    	
    	/*
        MinHeap heap = new MinHeap(Vertex.count);
        buildHeap(start, heap);
        
        VertexSet set = new VertexSet();
        
        while (heap.size() > 0) {
       		//TODO 
        }
        */
        
        showPath(start, finish); //Recursive
    }
}
