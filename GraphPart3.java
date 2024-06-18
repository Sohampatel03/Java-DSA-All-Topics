import java.util.*;

public class GraphPart3 {

    static class Edge {
        int src;
        int des;
        int weight;

        Edge(int s, int d , int w) {
            this.src = s;
            this.des = d;
            this.weight = w;
        }
    }

    public static void sortTop(ArrayList<Edge>[] graph) { // Method name starts with lowercase
        boolean vis[] = new boolean[graph.length];
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                sortTopUtil(graph, i, vis, s); // Call to sortTopUtil
            }
        }
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " "); // Added space for better readability
        }
        System.out.println(); // Added newline at the end of output
    }

    public static void sortTopUtil(ArrayList<Edge>[] graph, int curr, boolean vis[], Deque<Integer> s) {
        vis[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                sortTopUtil(graph, e.des, vis, s);
            }
        }
        s.push(curr);
    }

    public static void printallpath(ArrayList<Edge> graph[], int src, int des, String path) {
        if (src == des) {
            System.out.print(path + src);
            return;
        }
        for (int i = 0; i < graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            printallpath(graph, e.des, des, path + des);
        }
    }
    static class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int p) {
            this.n = n;
            this.path = p;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }

    }

    public static void disjkstra(ArrayList<Edge> graph[] , int src){
        int dest[] = new int[graph.length];
        boolean vis[] = new boolean[graph.length];
        for(int  i =0; i<graph.length;i++){
            //jab i - source ke equal na ho tab infinity
            if(i != src){
                dest[i] = Integer.MAX_VALUE;//initialize infinite value for all the other nodes
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        //sorce wali node add kr di h
        pq.add(new Pair(src,0));
        while(!pq.isEmpty()){
            //pehla pair nikala priority queue se jo sorted aayega
            Pair curr = pq.remove();
            //agar visited nahi h toh visit kr lo
            if(!vis[curr.n]){
                vis[curr.n] = true;
            }
            //ye loop neigbor ke liye
            for(int i=0;i<graph[curr.n].size();i++){
                Edge e = graph[curr.n].get(i);
                int u = e.src;//source
                int v = e.des; // destination
                int w = e.weight; // wieght of the edge between the src to destination
                if(dest[u]+w < dest[v]){
                    dest[v] = dest[u] + w;
                    pq.add(new Pair(v , dest[v]));
                }
            }
        }

    }

    public static void main(String args[]) {
        int v = 4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        // Example edges
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 3));
        printallpath(graph, 0, 2, "");

        // sortTop(graph); // Call sortTop to perform topological sorting
    }
}
