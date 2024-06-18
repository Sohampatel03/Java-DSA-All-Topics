import java.util.ArrayList;

public class GraphPart5 {

    static class Edge{
        int src;
        int dest;
         int wt;

         Edge(int s , int d , int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
         }

        public static void Create(int flight[][] , ArrayList<Edge> graph[]){
            for(int i =0 ; i<graph.length; i++){
                graph[i] = new ArrayList<>();
            }

            for(int i =0; i<flight.length;i++){
                int src = flight[0][0];
                int dest = flight[0][1];
                int wt = flight[0][2];

                Edge e = new Edge(src , dest , wt);
                graph[src].add(e);
            }
        }
    }

     public static void helper(int image[][] , int sr , int sc , int color , boolean vis[][] , int orgcol){
        if(sr <0 || sc<0 || sr>=image.length || sc>=image[0].length || vis[sr][sc] || image[sr][sc] != orgcol){
            return;
        }
        vis[sr][sc] = true;
        image[sr][sc] = color;
        helper(image,sr,sc-1 , color , vis, orgcol);
           helper(image,sr,sc+1 , color , vis, orgcol);
              helper(image,sr-1,sc , color , vis, orgcol);
                 helper(image,sr+1,sc , color , vis, orgcol);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image , sr,sc,color,vis,image[sr][sc]);
        return image;
        
    }

    public static void main(String args[]){
        int n = 4;
        int flight[][] = {};
        int k = 1;
        
    }
    
}
