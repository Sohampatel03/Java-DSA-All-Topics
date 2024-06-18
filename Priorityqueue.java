import java.util.PriorityQueue;
import java.util.*;

public class Priorityqueue {
   /*  public static class Student implements Comparable<Student> {
        char name;
        int rank;

        Student(char name, int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;

        }
    }

    public static class point implements Comparable<point> {
        int x;
        int y;
        int distsqrt;
        int i;

        public void point(int x, int y, int distsqrt, int i) {
            this.x = x;
            this.y = y;
            this.distsqrt = distsqrt;
            this.i = i;
        }

        @Override
        public int compareTo(point p2) {
            return this.distsqrt - p2.distsqrt;
        }
    }
*/
 //  public static void minimumcost() {
  //  // this is the logic of minimum cost it is apply in the main class
  //      int arr[] = { 2, 3, 3, 4, 6 };
  //      for (int i = 0; i < arr.length; i++) {
  //          // pq.add(arr[i]);
  //      }
  //      int cost = 0;
  //      // while(pq.size() > 1){
  //      int min = pq.remove();
  //      int min2 = pq.remove();
  //      cost += min + min2;
  //      // pq.add(min+min2);
//
  //  }
  //  // System.out.print(cost);
    public static class Slidewindow implements Comparable<Slidewindow> {
        int value;
        int idx;

        public  Slidewindow(int value, int idx) {
            this.value = val;
            this.idx = idx;
        }

        public int compareTo(Slidewindow s2) {
            if (s2.value == this.value) {
                return s2.idx - this.idx;
            } else {
                return s2.value - this.value;
            }
        }
    }

 

    public static void main(String args[]) {
        int arr[] = {2,4,3,2,2,3,3,2,4};
        int k = 3;
        int res[] = new int[arr.length-k+1];
        PriorityQueue<Slidewindow> pq = new PriorityQueue<>();

        for(int i= 0 ; i<k;i++){
            pq.add(new Slidewindow(arr[i] , i));
        }
        res[0] = pq.peek().value;

        for(int i = k ; i < arr.length; i++){
            while(pq.size() > 0 && pq.peek().idx <= (i-k)){
                pq.remove();
            }
            pq.add(new Slidewindow(arr[i] , i));
            res[i-k+1] = pq.peek().value;
        }

    
    }

}
