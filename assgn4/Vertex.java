import java.util.LinkedList;


public  class Vertex {
    public final String name;
    private LinkedList<Edge> edges;
    public Vertex (String town) {
	this.name = town;
    }
    public boolean addEdge(Edge e) {
	edges.add(e);
	return true;
    }
    public boolean isAdjacent(Vertex v) {
	for (int i = 0; i < edges.size(); i++) {
	    Edge e = edges.get(i);
	    if (e.getVerticies()[0].equals(v) || e.getVerticies()[1].equals(v))
		return true;
	}
	return false;
    }
    //@Override
    public boolean equals(Vertex v) {
	return v.name.equals(this.name);
    }
}
