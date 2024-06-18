import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class QueueB {
    static class Stack{
        Deque<Integer> d = new LinkedList<>();
      public  void push(int data){
            d.addFirst(data);
        }
       public int pop(){
            return d.removeLast();
        }
       public int peek(){
            return d.getLast();

        }
        

    }
    /*
     * static int arr[];
     * static int size;
     * static int rear ;
     * static int front ;
     * Queue (int n){
     * arr= new int[n];
     * size = n;
     * rear = -1;
     * front = -1;
     * }
     * public static boolean isEmpty(){
     * return rear == -1 && front == -1;
     * }
     * public static boolean isfull(){
     * return (rear+1)%size == front;
     * }
     * public static void add(int data){
     * if(isfull()){
     * System.out.print("full");
     * return;
     * }
     * //add first element
     * if(front == -1){
     * front = 0;
     * }
     * rear = (rear+1)%size;
     * arr[rear] = data;
     * }
     * public static int remove(){
     * if(isEmpty()){
     * System.out.print("empty");
     * return -1;
     * }
     * 
     * int remvelement = arr[front];
     * front = (front +1)% size;
     * return remvelement;
     * }
     * public static int peek(){
     * if(isEmpty()){
     * System.out.print("empty");
     * return -1;
     * }
     * 
     * return arr[0];
     * }
     */
    public static void FirstNonReapetingC(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print("there is no non reapeting element -1");
            } else {
                System.out.println(q.peek());
            }
        }
    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firsthalf = new LinkedList<>();
        int size = q.size();
        for (int i = 0; i < size / 2; i++) {
            firsthalf.add(q.remove());
        }
        while (!firsthalf.isEmpty()) {
            q.add(firsthalf.remove());
            q.add(q.remove());
        }
    }

    public static void reverse(Queue<Integer> q) {
         Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }

    }
    
  

    public static void main(String args[]) {
     Stack s = new Stack();
     s.push(1);
     s.push(2);
     s.push(3);
     System.out.print(s.peek());


    }

}
