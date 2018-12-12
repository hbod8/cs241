
import java.util.*;

public class Graph {
    final int SIZE = 97;
    
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
	}
	if (indexTown2 < 0) {
		table[nextOpen] = new Vertex(town2);
		nextOpen++;
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



    /*private void buildHeap(String start, MinHeap heap) {
   	//TODO
	//
	 
        //heap.buildHeap();
        
    }*/
    
    private void showPath(String start, String finish) {
    
       //TODO
       //
       // System.out.println(first.town);
      
    }

    
    public void shortestPath(String start, String finish) {
    	
	/*

        MinHeap heap = new MinHeap(Vertex.count);
        buildHeap(start, heap);
        
        VertexSet set = new VertexSet();
        
        while (heap.size() > 0) {
       		//TODO 
        
        }
        
        showPath(start, finish);
        
	*/
    }
}
