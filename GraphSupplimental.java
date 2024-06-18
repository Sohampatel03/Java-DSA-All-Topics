import java.util.*;

public class GraphSupplimental {

    static class Edge {
        int src;
        int des;
        // int wt;

        Edge(int s, int d) {
            this.src = s;
            this.des = d;
            // this.wt = w;
        }
    }

    public static void topsort(ArrayList<Edge> graph[], int curr, boolean vis[], Stack<Integer> s) {
        vis[curr] = true;
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                topsort(graph, e.des, vis, s);
            }
        }
        s.push(curr);
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean vis[]) {
        vis[curr] = true;
        System.out.println(curr);
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!vis[e.des]) {
                dfs(graph, e.des, vis);
            }
        }
    }

    public static void kosoraju(ArrayList<Edge> graph[], int v) {
        // step 1st (topsort)
        Stack<Integer> s = new Stack<>();
        boolean vis[] = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                topsort(graph, i, vis, s);
            }
        }

        // step 2 (transpose the graph)
        ArrayList<Edge> Transpose[] = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            vis[i] = false;
            Transpose[i] = new ArrayList<Edge>();
        }
        for (int i = 0; i < v; i++) {
            for (int j = 0; i < graph[i].size(); i++) {
                Edge e = graph[j].get(i);
                Transpose[e.des].add(new Edge(e.des, e.src));
            }
        }

        // step 3 (dfs from the stack elements)

        while (!s.isEmpty()) {
            int curr = s.pop();
            if (!vis[curr]) {
                dfs(Transpose, curr, vis);
            }
        }
    }

    public static void main(String args[]) {

    }
}