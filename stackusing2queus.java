import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class stackusing2queus {
    static class QueueB {
        static Queue<Integer> Q1 = new LinkedList<>();
        static Queue<Integer> Q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return Q1.isEmpty() && Q2.isEmpty();
        }

        public static void push(int data) {
            if (!Q1.isEmpty()) {
                Q1.add(data);
            } else {
                Q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.print("stack empty");
                return -1;
            }
            int top = -1;
            // case 1
            if (!Q1.isEmpty()) {
                while (!Q1.isEmpty()) {
                    top = Q1.remove();
                    if (Q1.isEmpty()) {
                        break;
                    }
                    Q2.add(top);
                }
                // case 2
            } else {
                while (!Q2.isEmpty()) {
                    top = Q2.remove();
                    if (Q2.isEmpty()) {
                        break;
                    }
                    Q1.add(top);
                }

            }
            return top;
        }
       
        public static int peek() {
            if (isEmpty()) {
                System.out.print("stack empty");
                return -1;
            }
            int top = -1;
            // case 1
            if (!Q1.isEmpty()) {
                while (!Q1.isEmpty()) {
                    top = Q1.remove();
                    Q2.add(top);
                    // case 2
                }
            } else {
                while (!Q2.isEmpty()) {
                    top = Q2.remove();

                    Q1.add(top);
                }

            }
            return top;
        }
    }

    public static void main(String args[]){
    

    }


}
