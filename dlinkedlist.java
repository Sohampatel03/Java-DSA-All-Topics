public class dlinkedlist {
    public class Node {
        int data;
        Node prev;
        Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addf(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    public static int removef() {
        if (head == null) {
            System.out.print("empty linked list");
            return Integer.MIN_VALUE;
        }
        if (size == 1) {
            head = tail = null;
            size--;
        }
        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public static void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]) {
        dlinkedlist dou = new dlinkedlist();
        dou.addf(3);
        dou.addf(2);
        dou.addf(1);
        reverse();
        dou.print();
    }
}
