



import java.util.*;
import java.io.*;
import java.util.*;

public class Assignment4 {

    private static Graph graph;
    
    private static int edges;

    private static int buildGraph(String input) {    
	try {
	    Scanner inputFile = new Scanner(new File(input));
	    graph = new Graph();
	    while (inputFile.hasNextLine()) {
		    String line = inputFile.nextLine();
		    String[] csvs = line.split(",");
		    graph.insert(csvs[0], csvs[1], Integer.parseInt(csvs[2]));
		    edges++;
	    }
	}
	catch (IOException e) {
	    System.out.println("Cannot read from file: " + e.toString());
	}
	return graph.SIZE;
    }


    public static void main (String args[]) {
        int count = buildGraph(args[0]);
        
        System.out.println(count + " towns expected " + graph.count + " towns added to graph\n" + edges + " connections between those towns.");

	Edge[] edges = graph.table[graph.find("Wagga Wagga")].getEdges();
	/*
	for (int i = 0; i < edges.length; i++) {
		System.out.println("Wagga Wagga is " + edges[i].distance + " away from " + edges[i].getVerticies()[1].name);
	}
	*/
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        catch (Exception e) {
            System.out.println("Cannot accept input");
            return;
        }
        
        String town1, town2;
        while (true) {
        
            try {
                System.out.print("First town: ");
                town1 = br.readLine();
                if (town1.length() == 0)
                    return;
            
                System.out.print("Second town: ");
                town2 = br.readLine();
            }
            catch (Exception e) {
                System.out.println("Input error: " + e);
                return;
            }
            
            graph.shortestPath(town1, town2);
        }
        

    }


}
