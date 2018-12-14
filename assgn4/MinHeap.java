import java.util.*;


public class MinHeap {
    //private boolean[] visited;
    //private int[] distance;
    private final int INFINITY = Integer.MAX_VALUE;
    private final int SIZE;
    private int visitedSize;
    private Graph graph;
    public MinHeap(int size, Graph g) {
	this.SIZE = size;
	visitedSize = size;
	this.graph = g;
    }

    public void buildHeap() {
	//visited = new boolean[SIZE];
	//distance = new int[SIZE];
	for (int i = 0; i < SIZE; i++) {
		if (graph.table[i] != null)
    			graph.table[i].distance = INFINITY;
    	}
    }
    
    public void minHeapify() {
        for (int i = visitedSize/2-1; i >= 0; i--)
            minHeapify(i);    
    }


    private void minHeapify(int root) {
    	int min = root, l = 2*root + 1, r = 2*root + 2;
	if (graph.table[l].distance < graph.table[min].distance && l < visitedSize) {
		min = l;
	}

	if (graph.table[r].distance < graph.table[min].distance && r < visitedSize) {
		min = r; 
	}

	if (min != root) {
		/*
		// swap distances
		int tempDist = distance[root];
		distance[root] = distance[min];
		distance[min] = tempDist;
		// swap visited
		boolean tempVisit = visited[root];
		visited[root] = visited[min];
		visited[min] = tempVisit;
		*/
		// swap Verticies
		Vertex tempVert = graph.table[root];
		graph.table[root] = graph.table[min];
		graph.table[min] = tempVert;
		minHeapify(min);
	}
    }

    public void setStart(int i) {
	graph.table[i].distance = 0;
	/*
	// swap distances
	int tempDist = distance[0];
	distance[0] = distance[i];
	distance[i] = tempDist;
	// swap visited
	boolean tempVisit = visited[0];
	visited[0] = visited[i];
	visited[i] = visited[0];
	*/
	// swap Verticies
	Vertex tempVert = graph.table[0];
	graph.table[0] = graph.table[i];
	graph.table[i] = tempVert;
    }

    public int size() {
        return SIZE;
    }


    public void extract() {
	  // int end = SIZE - 1;
	  //
	  //
	   Vertex temp = graph.table[0];



	   graph.table[0] = graph.table[visitedSize];
	   graph.table[visitedSize] = temp;
	   graph.table[visitedSize].visited = true;
	   visitedSize--;
	   minHeapify();
    }
}
