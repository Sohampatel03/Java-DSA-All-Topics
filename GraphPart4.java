import java.util.PriorityQueue;

public class GraphPart4 {
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

    public static void BellmanFord(ArrayList<Edge> graph[] , int src){
        int dist[] = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            if(i != src){
                dist[i] = Integer.MAX_VALUE;
            }
        }
        int v = graph.length;
        //this  loop for relaxing for negative value of edge
        for(int i=0; i<v-1; i++){
            //this loop is for the every node
            for(int j=0; j<graph.length; i++){
                //this loop is for node of neigbor
                for(int k=0; k<graph[j].size(); k++){
                    Edge e = graph[j].get(k);
                    //this is the formula to calculate the minimum distance
                    if(dist[e.src] != Integer.MAX_VALUE && dist[e.src] + e.weight < dist[e.des]){
                        dist[e.des] = dist[e.src] + e.weight;
                    }
                }
            }
        }

        for(int i =0; i<dist.length;i++){
            System.out.print(dist[i]);
        }
    }

    static class Pair implements Comparable<Pair>{
        int v;
        int cost;

        Pair(int n , int c){
            this.v = n;
            this.cost = c;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost - p2.cost;
        }

    }
k
    public static void Prims(ArrayList<Edge> graph[]){
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(0,0);
        int totalcost = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.remove(); 
            if(!vis[curr.v]){
                vis[curr.v] = true;
                totalcost += curr.cost;
            }
            for(int i=0; i<graph[curr.v]; i++){
                Edge e = graph[curr.v].get(i);
                pq.add(new Pair(e.des , e.weight));
            }
        }

    

    }


}
