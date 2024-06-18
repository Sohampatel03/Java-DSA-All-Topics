import java.util.*;
import java.util.LinkedList;

public class free {
    static class Queue {
       Deque<Integer> q = new LinkedList<>();
       public void add(int data){
        q.addLast(data);
       }
       public int remove(){
        return q.removeFirst();
       }
       public int get(){
        return q.getFirst();
       }

    }

    public static void main(String args[]) {
       Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.get());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());

    }

}
