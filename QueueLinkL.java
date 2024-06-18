public class QueueLinkL{
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head = null;
    public static Node tail = null;
    public static boolean isEmpty(){
        return head == null & tail == null;
    }
    public static void add(int data){
        Node n = new Node(data);
        if(head == null){
            head = tail = n;
            return;
        }
        tail.next = n;
        tail = n;
    }
    public static int remove(){
        if(isEmpty()){
            System.out.print("empty");
            return -1;
        }
        int front = head.data;
        if(head == tail){
            head = tail = null;
            return -1;
        }else {
            head = head.next;
        }
        return front;
    }
    public static int peek(){
        return head.data;
    }

}