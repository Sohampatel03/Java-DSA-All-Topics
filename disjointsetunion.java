import java.util.*;
public class disjointsetunion{
    static int n = 7;
    static int par[] = new int[n];
    static int rank[] = new int[n];

    public static void init(){
        for(int i=0 ; i<par.length; i++){
            par[i] = i;
        }
    }

    public static int find(int x){
        if(x == par[x]){
            return x;
        }
       return find(par[x]);
    }

    public static void union(int n1 , int n2){
        int parn1 = par[n1];
        int parn2 = par[n2];
        if(rank[parn1] == rank[parn2]){
            par[parn2] = parn1;
            rank[parn1]++;
        }else if(rank[parn1] < rank[parn2]){
            par[parn1] = parn2;
        }else{
            par[parn2] = parn1;
        }
    }

    //optimal code write in a copy there is only one change in find funtion 
    //that reduce the time complexity from 0(n) to 0(1)
    //the one line change is  { return par[x] = find(par[x]);}

    public static void krushkal(ArrayList<Edge> edges , int v){
        init();
        Collections.sort(edges);
        int mstcount = 0;
        int count = 0;

        for(int i= 0; count < v-1; i++){
            Edge e = edges.get(i);
            int parA = e.src;
            int parB = e.des;

            if(parA != parB){
                union(e.src , e.des);
                mstcount += e.wt;
                count++;
            }

        }
    }
   

    public static void main(String args[]){
        init();
        System.out.print(find(3));
        union(1,3);
        System.out.print(find(3));
    union(2,4);
    union(3,6);
    union(1,4);
    System.out.print(find(3));
    union(1,5);
    
        }

}