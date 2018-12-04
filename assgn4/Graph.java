
import java.util.*;

public class Graph {
    final int SIZE = 97;
    
    Vertex[] table = new Vertex[SIZE];

    public Graph() {

    }
    public void insert(String town1, String town2, int distance) {
	// TODO
    }
    
    private void buildHeap(String start, MinHeap heap) {
   	//TODO
	//
	 
        heap.buildHeap();
        
    }
    
    private void showPath(String start, String finish) {
    
       //TODO
       //
        System.out.println(first.town);
      
    }

    
    public void shortestPath(String start, String finish) {
    
        MinHeap heap = new MinHeap(Vertex.count);
        buildHeap(start, heap);
        
        VertexSet set = new VertexSet();
        
        while (heap.size() > 0) {
       		//TODO 
        
        }
        
        showPath(start, finish);
        
    }
}
