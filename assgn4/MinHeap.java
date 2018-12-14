import java.util.*;


public class MinHeap {
    private final int INFINITY = Integer.MAX_VALUE;
    private final int SIZE;
    private int visitedSize;
    private Graph graph;
    public MinHeap(int size, Graph g) {
	this.SIZE = size;
	visitedSize = size - 1;
	this.graph = g;
    }

    public void buildHeap() {
	for (int i = 0; i < SIZE; i++) {
		if (graph.table[i] != null)
    			graph.table[i].distance = INFINITY;
    	}
    }
    
    public void minHeapify() {

        for (int i = visitedSize / 2 - 1; i >= 0; i--)
            minHeapify(i);    
    }


    private void minHeapify(int current) {
    	int min = current, l = 2*current, r = 2*current + 1;
	System.out.println ("root: " + current + " l: " + l + " r: " + r);
	if (graph.table[l].distance < graph.table[min].distance && l < visitedSize) {
		min = l;
	}

	if (graph.table[r].distance < graph.table[min].distance && r < visitedSize) {
		min = r; 
	}
	System.out.println("root: " + current + " min: " + min);
	if (min != current) {
		Vertex tempVert = graph.table[current];
		graph.table[current] = graph.table[min];
		graph.table[min] = tempVert;
		System.out.println (min);
		minHeapify(min);
	}
    }

    public void setStart(int i) {
	graph.table[i].distance = 0;
	Vertex tempVert = graph.table[0];
	graph.table[0] = graph.table[i];
	graph.table[i] = tempVert;
    }

    public int size() {
        return SIZE;
    }


    public void extract() {
	   Vertex temp = graph.table[0];
	   graph.table[0] = graph.table[visitedSize];
	   graph.table[visitedSize] = temp;
	   graph.table[visitedSize].visited = true;
	   visitedSize--;
	   minHeapify();
    }
}
