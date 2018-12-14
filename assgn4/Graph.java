
import java.util.*;

public class Graph {
    final int SIZE = 89;
    public int count = 0;
    private int nextOpen = 0;

    Vertex[] table = new Vertex[SIZE];

    public Graph() {

    }
    public void insert(String town1, String town2, int distance) {
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
	if (!start.equals(finish)) {
		System.out.println(finish + " (" + table[find(finish)].distance + ")");
		showPath(start, table[find(finish)].previous.name);
	}
	else {
		System.out.println(start + " (" + table[find(start)].distance + ")");
	}
    }
    private Vertex last = null;
    public void shortestPath(String start, String finish) {
    	MinHeap heap = new MinHeap(SIZE, this);
	buildHeap(start, heap);
	while (!table[0].name.equals(finish)) {
		//System.out.println("Lowest distance town is " + table[0].name);
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
				//table[0].distance = currentDistFromStart + distFromCurToAdj;
				table[0].getEdges()[i].getVerticies()[1].distance = currentDistFromStart + distFromCurToAdj;
				table[0].getEdges()[i].getVerticies()[1].previous = table[0];
				//System.out.println("Calculated new distance for " + table[0].getEdges()[i].getVerticies()[1].name + " of " + (currentDistFromStart + distFromCurToAdj));
			}
			else {
				//System.out.println("Did not calculate new distance between " + table[0].name + " and " + table[0].getEdges()[i].getVerticies()[1].name + " (" + currentDistFromStart + "+" + distFromCurToAdj + "->" + currentDistOfAdjNodeFromStart + ").");
			}
		}
		last = table[0];
		heap.extract();
	}
	if (table[0].name.equals(finish)) {
		table[0].previous = last;
	}
        showPath(start, finish);
    }
}
