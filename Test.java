import java.util.Scanner;

/**
 * Main test program
 * offers the ability to test randomly generated matrices
 * as well as matrices read from Scanner
 * @author Sophie Quigley
 * <br>You can modify this testing program as you wish to perform your tests
 */
public class Test {
    /**
     * Test graph
     */
    private static Graph graph;
    /**
     * Input stream
     */
    private static Scanner in = new Scanner(System.in);
    /**
     * Main test program either calls testRandom, testInput, or both.
     * @param args the command line arguments
     */     
    public static void main(String[] args) {
        in = new Scanner("2 1 2 2 1");
    	
    	//testRandom();
        testInput();
    }
   /**
    * Loops generating a random graph and looking for its Euler circuit if there is one
    */ 
    private static void testRandom() {
        for (int max=1; max<=5; max++) {
            graph = new Graph(6,max);
            processGraph();
        }        
    }
    
    /**
    * Loops reading graph from scanner and looking for its Euler circuit if there is one
    */ 
    private static void testInput() {
        while (in.hasNext())    {
            graph = new Graph(in);
            processGraph();
        }

    }
    
    /**
     * Prints graph, then looks for Euler circuit and print it out if one is found.
     */
    private static void processGraph() {
        // Print graph
        System.out.println("Graph has " + graph.getVertices() 
            + " vertices, and " + graph.getEdges() + " edges.");
        System.out.print(graph);
                    
        // Try to find an Euler circuit
        if (graph.hasEulerCircuit(true)) {
            Walk Euler = graph.getEulerCircuit();
            System.out.println(
                "Graph has the following Euler Circuit:\n" 
                    + Euler);  
        }
        else if (!graph.hasEulerCircuit(false)){
        	System.out.println("no circuit here");
        }
    }
    

}
