import java.util.*;
import java.util.Stack;

/*  static class stack {
       static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isempty() {
            return list.size() == 0;
        }
        public static void push(int data){
            list.add(data);
        }
        public static int pop(){
            if(isempty()){
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }
        public static int peep() {
            if(isempty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            return top;

        }

   }*/
/*  static class Node {
  int data;
  Node next;
   Node(int data){
      this.data = data;
      this.next = null;
   }
  }
   static class stack{
      static Node head = null;
     public static boolean isempty(){
          return head == null;
      }
     public static void push(int data){
      Node newnode = new Node(data);
      if(isempty()){
          head = newnode;
          return ; 
      }
      newnode.next = head;
      head = newnode;
      }
      public static int pop(){
          if(isempty()){
              return -1;
          }
          int top = head.data;
          head = head.next;
          return top;
      }
      public static int peek(){
          if(isempty()){
              return -1;
          }
          return head.data;
      }
   }*/

public class StackB {
    public static void pushbottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushbottom(s, data);
        s.push(top);
    }

    public static void reversestack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reversestack(s);
        pushbottom(s, top);
    }

    public static void printstack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.print(s.peek());
            s.pop();
        }
    }

    public static void stockspan(int stock[], int span[]) {
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);
        for (int i = 1; i < stock.length; i++) {
            int curr = stock[i];
            // while loop for the previus high
            while (!s.isEmpty() && curr > stock[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }// else condition if the previous high we got it
            else{
                int prevhigh = s.peek();
                span[i] = i - prevhigh;
            }
            s.push(i);
        }
    }

    public static void Nextgreater(int arr[]) {
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        int arr2[] = new int[n];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) {
                s.pop();
            }
            // step 2 if else
            if (s.isEmpty()) {
                arr2[i] = -1;
            } else {
                arr2[i] = arr[s.peek()];
            }
            // step 3 push
            s.push(i);
        }
        for (int i = 0; i <= arr2.length - 1; i++) {
            System.out.print(arr2[i]);

        }
    }

    public static boolean Checkparenthesis(String s) {
        Stack<Character> ss = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '{' || curr == '[' || curr == '(') {
                ss.push(curr);
            } else {
                if (ss.isEmpty()) {
                    return false;
                }
                if (ss.peek() == '{' && curr == '}' || ss.peek() == '[' && curr == ']' ||
                        ss.peek() == '(' && curr == ')') {
                    ss.pop();
                } else {
                    return false;
                }
            }
        }
        if (ss.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isduplicate(String str) {
        Stack<Character> ss1 = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            // closing
            if (curr == ')') {
                int count = 0;
                while (ss1.peek() != '(') {
                    ss1.pop();
                    count++;
                }
                if (count < 1) {
                    return true;
                } else {
                    ss1.pop();
                }
            } else {
                // opening braget
                ss1.push(curr);
            }
        }
        return false;
    }

    public static void Histogram(int arr[]) {
        int Maxarea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];
        int ri = 0;
        // next smaller right
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsr[i] = arr.length;
                ri++;
            } else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        // next smaller left
        s = new Stack<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            while (!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }
        // calculate area area = arr[i] * (nsr - nsl -1);
        for (int i = 0; i <= arr.length - 1; i++) {
            int curr = arr[i] * (nsr[i] - nsl[i] - 1);
            Maxarea = Math.max(curr, Maxarea);
        }
        System.out.println("Max area is histogram = " + Maxarea);
    }

    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        int arr[] = { 6, 8, 0, 1, 3 };
        Nextgreater(arr);
        String str = new String();
        str = "( )";
        // System.out.println(Checkparenthesis(str));
        System.out.println (isduplicate(str));
        int arr1[] = { 2, 1, 5, 6, 2, 3 };
        Histogram(arr1);
    }
}
