import java.util.LinkedList;


public  class Vertex {
    public int distance;
    public boolean visited = false;
    public final String name;
    public Vertex previous = null;
    private LinkedList<Edge> edges = new LinkedList<Edge>();
   
    public Vertex (String town) {
	this.name = town;
    }
   
   //Adds an edge to the linked list of the Vertex
    public boolean addEdge(Edge e) {
	//System.out.println("adding " + e.getVerticies()[0].name + " --" + e.distance + "-> " + e.getVerticies()[1].name);
	edges.add(e);
	return true;
    }

    //Checks if two verticies are adjacent
    public boolean isAdjacent(Vertex v) {
	for (int i = 0; i < edges.size(); i++) {
	    Edge e = edges.get(i);
	    if (e.getVerticies()[0].equals(v) || e.getVerticies()[1].equals(v))
		return true;
	}
	return false;
    }

    //Returns an array of edges connected to the vertex
    public Edge[] getEdges() {
	Edge[] edgearr = new Edge[edges.size()];
	for (int i = 0; i < edges.size(); i++) {
		edgearr[i] = edges.get(i);
	}
	return edgearr;
    }

    //Returns true if the vertex is the same object
    public boolean equals(Vertex v) {
	return v.name.equals(this.name);
    }
}
