import java.util.LinkedList;


public  class Vertex {
    public final String name;
    private LinkedList<Edge> edges;
    public Vertex (String town) {
	this.name = name;
    }
    public boolean addEdge(Edge e) {
	edges.add(e);
    }
    public boolean isAdjecent(Vertex v) {
	for (int i = 0; i < edges.size(); i++) {
	    Edge e = edges.get(i);
	    if (e.getVerticies()[0]
	}
    }
    @Override
    public boolean equals(Vertex v) {
	return v.name.equals(this.name);
    }
}
