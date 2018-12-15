import java.util.*;


public class MinHeap {
    private final int INFINITY = 1000000;
    private final int SIZE;
    private int visitedSize;
    private Graph graph;
    public MinHeap(int size, Graph g) {
	this.SIZE = size;
	visitedSize = size - 1;
	this.graph = g;
    }
    
    //Sets distances to infinity
    public void buildHeap() {
	for (int i = 0; i < SIZE; i++) {
		if (graph.table[i] != null)
    			graph.table[i].distance = INFINITY;
    	}
    }
    
    public void minHeapify() {

	minHeapify(0, visitedSize);
        for (int i = visitedSize / 2 - 1; i >= 0; i--)
            minHeapify(i, visitedSize);
	for (int j = visitedSize; j >= 0; j--) {
		Vertex temp = graph.table[0];
		graph.table[0] = graph.table[j];
		graph.table[j] = temp;
		minHeapify(0, j);
	}
	for (int i = 0; i < visitedSize; i++) {
		if (graph.table[i].distance < graph.table[0].distance) {
			Vertex temp = graph.table[0];
			graph.table[0] = graph.table[i];
			graph.table[i] = temp;
		}
	}
	/*
	System.out.print("[");
	for (int i = 0; i < visitedSize; i++) {
		System.out.print("(" + graph.table[i].name + "," + graph.table[i].distance + ")");
	}
	System.out.print("]");
	*/
    }

    ///*
    
    //Sorts heap
    private void minHeapify(int current, int size) {
	int min = current, l = 2*current + 1, r = 2*current + 2;
	//System.out.println ("root: " + current + " l: " + l + " r: " + r);
	if (l < visitedSize && graph.table[l].distance > graph.table[min].distance) {
		min = l;
	}
	if (r < visitedSize && graph.table[r].distance > graph.table[min].distance) {
		min = r; 
	}
	//System.out.println("root: " + current + "(" + graph.table[current].name + ") min: " + min);
	if (min != current) {
		Vertex tempVert = graph.table[current];
		graph.table[current] = graph.table[min];
		graph.table[min] = tempVert;
		minHeapify(min, size);
	}
    }
    //*/
    
    //Sets the first town's distance to zero instead of infinity and moves it to the start of the heap
    public void setStart(int i) {
	graph.table[i].distance = 0;
	Vertex tempVert = graph.table[0];
	graph.table[0] = graph.table[i];
	graph.table[i] = tempVert;
    }

    public int size() {
        return SIZE;
    }

    //Updates the heap by swapping the first and last elements and then reducing the unused size of the array by 1
    public void extract() {
	   Vertex temp = graph.table[0];
	   graph.table[0] = graph.table[visitedSize];
	   graph.table[visitedSize] = temp;
	   graph.table[visitedSize].visited = true;
	   visitedSize--;
	   minHeapify();
    }
}
