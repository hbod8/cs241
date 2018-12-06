



import java.util.*;
import java.io.*;
import java.util.*;

public class Assignment4 {

    private static Graph graph;
    
    private static int buildGraph(String input) {
	// should be able to read input from a file
	// specified in the first command-line argument
	// TODO    
	try {
	    Scanner inputFile = new Scanner(new File(input));
	    while (inputFile.hasNextLine()) {
		
	    }
	}
    }


    public static void main (String args[]) {
    
        // build the graph from the input file
        int count = buildGraph(args[0]);
        
        System.out.println(count + " towns added to graph");
        
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
