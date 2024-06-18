import java.util.*;

public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public static void add(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;
    }

    public void last(int data) {
        Node newnode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    public void print() {
        if (head == null) {
            System.out.print("empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println(); // Add a line break after printing the list
    }

    public static void add(int idx, int data) {
        if (idx == 0) {
            add(data);
            return;
        }
        Node newn = new Node(data);
        size++;
        int i = 0;
        Node temp = head;
        while (i < idx) {
            temp = temp.next;
            i++;
        }
        newn.next = temp.next;
        temp.next = newn;
    }

    public static int itrsearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public static int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) {
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public static int recsearch(int key) {
        return helper(head, key);
    }

    public static void reverse() {
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void deleten(int n) {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (size == n) {
            head = head.next;
            return;
        }
        int i = 0;
        int itofind = size - n;
        Node prev = head;
        while (i < itofind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    public static Node findmid() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static boolean pelindrome() {
        if (head == null && head.next == null) {
            return true;
        }
        Node mid = findmid();

        Node curr = mid;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            right = right.next;
            left = left.next;
        }
        return true;
    }

    public static boolean iscycle() { // floid's cycle finding algorithm
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public static void deletecycle() {
        boolean cycle = false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (cycle == false) {
            cycle = false;
        }
        slow = head;
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;

    }

    public static Node mergesort(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        // mid
        Node mid = getmid(head);
        // rigt and left sorted list
        Node righthead = mid.next;
        mid.next = null;
        Node right = mergesort(righthead);
        Node left = mergesort(head);
        // merge
        return merge(left, right);
    }

    // getmid function of merge sort
    private static Node getmid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge function
    public static Node merge(Node left, Node right) {
        Node mergell = new Node(-1);
        Node temp = mergell;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                temp.next = left;
                left = left.next;
                temp = temp.next;
            } else {
                temp.next = right;
                right = right.next;
                temp = temp.next;
            }
        }
        // left remaining elements
        while (left != null) {
            temp.next = left;
            left = left.next;
            temp = temp.next;
        }
        // right remaning elements
        while (right != null) {
            temp.next = right;
            right = left.next;
            temp = temp.next;
        }
        return mergell.next;
    }

    public static void zigzag() {
        // 1st step fint mid
        Node mid = findmid();
        // 2nd step reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // 3rd step alternate merge
        Node left = head;
        Node right = prev;
        Node nextl, nextr;
        while (left != null && right != null) {
            nextl = left.next;
            left.next = right;
            nextr = right.next;
            right.next = nextl;

            left = nextl;
            right = nextr;
        }
    }
    
    

    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.print();
        ll.head = mergesort(ll.head);
        ll.print();
    }
}
