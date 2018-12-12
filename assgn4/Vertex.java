import java.util.LinkedList;


public  class Vertex {
    public final String name;
    private LinkedList<Edge> edges = new LinkedList<Edge>();
    public Vertex (String town) {
	this.name = town;
    }
    public boolean addEdge(Edge e) {
	System.out.println("adding " + e.getVerticies()[0].name + " --" + e.distance + "-> " + e.getVerticies()[1].name);
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
    public Edge[] getEdges() {
	Edge[] edgearr = new Edge[edges.size()];
	for (int i = 0; i < edges.size(); i++) {
		edgearr[i] = edges.get(i);
	}
	return edgearr;
    }
    //@Override
    public boolean equals(Vertex v) {
	return v.name.equals(this.name);
    }
}
