package SecondBestMST;

import java.util.*;

public class SecondBestMSTKruskal {

    private int vertices;
    private List<Edge> edges;

    public SecondBestMSTKruskal(int vertices) {
        this.vertices = vertices;
        edges = new ArrayList<>();
    }

    public void addEdge(int src, int dest, int weight) {
        edges.add(new Edge(src, dest, weight));
    }

    private int find(int[] parent, int vertex) {
        if (parent[vertex] == -1) {
            return vertex;
        }
        return find(parent, parent[vertex]);
    }

    private void union(int[] parent, int x, int y) {
        int rootX = find(parent, x);
        int rootY = find(parent, y);
        parent[rootX] = rootY;
    }

    public List<Edge> findSecondBestMST() {
        Collections.sort(edges);

        List<Edge> mst = new ArrayList<>();
        int[] parent = new int[vertices];
        Arrays.fill(parent, -1);

        for (Edge edge : edges) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            if (rootSrc != rootDest) {
                mst.add(edge);
                union(parent, rootSrc, rootDest);
            }
        }


        int maxWeight = -1;
        Edge excludedEdge = null;
        for (Edge edge : mst) {
            if (edge.weight > maxWeight) {
                maxWeight = edge.weight;
                excludedEdge = edge;
            }
        }


        mst.remove(excludedEdge);


        Arrays.fill(parent, -1);

        List<Edge> secondMST = new ArrayList<>();

        for (Edge edge : mst) {
            int rootSrc = find(parent, edge.src);
            int rootDest = find(parent, edge.dest);

            if (rootSrc != rootDest) {
                secondMST.add(edge);
                union(parent, rootSrc, rootDest);
            }
        }

        return secondMST;
    }

    public static void main(String[] args) {
        SecondBestMSTKruskal graph = new SecondBestMSTKruskal(5);

        // Sample Input:
        /*
        0 1 2
        0 2 3
        1 2 5
        1 3 1
        2 3 4
        2 4 6
        3 4 3
        */

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 2, 3);
        graph.addEdge(1, 2, 5);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 3, 4);
        graph.addEdge(2, 4, 6);
        graph.addEdge(3, 4, 3);

        List<Edge> secondMST = graph.findSecondBestMST();



        System.out.println("Second Best Minimum Spanning Tree Edges:");
        for (Edge edge : secondMST) {
            System.out.print("(" + edge.src + ", " + edge.dest + ", " + edge.weight + ") ");
        }
    }
}
