public class Edge {
    private Vertex town1, town2;
    public final int distance;
   
    //Constructor
    public Edge (Vertex town1, Vertex town2, int distance) {
    	this.town1 = town1;
	this.town2 = town2;
	this.distance = distance;
    }
   
   //Returns an array with the two towns the edge connects
    public Vertex[] getVerticies() {
	Vertex[] verts = new Vertex[2];
	verts[0] = town1;
	verts[1] = town2;
	return verts;
    }
}
