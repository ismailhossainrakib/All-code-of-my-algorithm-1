package DFS;
import java.util.*;

public class DFSGraphTraversal {

    private int vertices;
    private LinkedList<Integer>[] adjacencyList;

    public DFSGraphTraversal(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination);
    }

    public void dfsTraversal(int startVertex) {
        boolean[] visited = new boolean[vertices];
        dfsUtil(startVertex, visited);
    }

    private void dfsUtil(int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");

        for (int neighbor : adjacencyList[currentVertex]) {
            if (!visited[neighbor]) {
                dfsUtil(neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample Input:
        /*
        5
        7
        0 1
        0 2
        1 3
        1 4
        2 4
        3 4
        4 0
        0
        */

        System.out.print("Enter the number of vertices: ");
        int vertices = scanner.nextInt();

        DFSGraphTraversal graph = new DFSGraphTraversal(vertices);

        System.out.print("Enter the number of edges: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (source destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        System.out.print("Enter the starting vertex for DFS traversal: ");
        int startVertex = scanner.nextInt();

        System.out.print("DFS Traversal starting from vertex " + startVertex + ": ");
        graph.dfsTraversal(startVertex);

        scanner.close();
    }
}
