import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BFS {
    static class Edge {
        int src;
        int dest;

        public Edge (int s , int d) {
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph[]) {
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<Edge>();
        }
    }

    public static void addEdge(ArrayList<Edge> graph[] , int s , int d) {
        graph[s].add(new Edge(s, d));
        graph[d].add(new Edge(d, s));
    }

    public static void bfs(ArrayList<Edge> graph[] , int V , int que) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        int par[] = new int[V];

        q.add(que);
        par[que] = -1;

        while (!q.isEmpty()) {
            int curr = q.remove();
            if(vis[curr] == false) {
                System.out.println("Current vertex:"+curr+" "+"Parent vertex:"+par[curr]);
                vis[curr] = true;

                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    int nextVertex = e.dest;
                    if (!vis[nextVertex]){
                        q.add(e.dest);
                        par[nextVertex] = curr;
                    }
                }
            }
        }
    }

    public static void main (String args[]) {
        int V , que;
        ArrayList<Edge> graph[];

        try {
            String filepath = "BFS.txt";
            File file = new File(filepath);
            Scanner scanf = new Scanner(file);

            V = scanf.nextInt();
            que = scanf.nextInt();

            graph = new ArrayList[V];
            createGraph(graph);

            while (scanf.hasNext()) {
                int s = scanf.nextInt();
                int d = scanf.nextInt();
                addEdge(graph,s,d);
            }

            bfs(graph, V , que);
            scanf.close();
        } catch (FileNotFoundException e) {
            System.out.println("Problem");
        }
    }
}