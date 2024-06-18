import java.util.*;
import java.util.Queue;
import java.util.LinkedList;
public class GraphAdjacancy {

    static class Edge{
        int src;
        int des;
        int wed;
        
        Edge(int s, int d , int w){
            this.src = s;
            this.des = d;
            this.wed = w;
        }
    }

    public static void breathFS(ArrayList<Edge>[] graph){ // 0(V+E)
        Queue<Integer> q = new LinkedList<>();
        boolean visit[] = new boolean[graph.length];
        q.add(0); // source vertex
        while(!q.isEmpty()){
            int curr = q.remove();

            if(!visit[curr]){
                System.out.print(curr);
                visit[curr] = true;
                for(int i=0; i<graph[curr].size(); i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.des);
                }
            }
        }


    }
    public static void main(String args[]){
        int vertex = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge> graph[] = new ArrayList[vertex];
        for(int i=0; i<vertex; i++){
            graph[i] = new ArrayList<>();
        }

        //for 0 vertex
        graph[0].add(new Edge(0,1,1));
        //for 1 vertex
        graph[1].add(new Edge(1,0,5));
        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,3));
        //for 2 vertex
        graph[2].add(new Edge(2,1,1));
        graph[2].add(new Edge(2,3,1));
        graph[2].add(new Edge(2,4,2));
        //for 3 vertex
        graph[3].add(new Edge(3,1,3));
        graph[3].add(new Edge(3,2,1));
        //for 4 vertex
        graph[4].add(new Edge(4,2,2));

        for(int i=0; i<graph[2].size(); i++){
            Edge e = graph[2].get(i);
            System.out.print(e.des);
        }


    }
    
}
