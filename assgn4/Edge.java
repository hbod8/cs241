


public class Edge {
    private Vertex town1, town2;
    public final int distance;
    public Edge (Vertex town1, Vertex town2, int distance) {
    	this.town1 = town1;
	this.town2 = town2;
	this.distance = distance;
    }
    public Vertex[] getVerticies() {
	Vertex[] verts = new Vertex[2];
	verts[0] = town1;
	verts[1] = town2;
	return verts;
    }
}
