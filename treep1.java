import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;

public class treep1 {

    static class Node {
        int data;
        Node lefttree;
        Node righttree;

        Node(int data) {
            this.data = data;
            this.lefttree = null;
            this.righttree = null;
        }
    }

    static class binarytree {
        static int idx = -1;

        public static Node buildtree(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.lefttree = buildtree(nodes);
            newNode.righttree = buildtree(nodes);

            return newNode;

        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data);
            preorder(root.lefttree);
            preorder(root.righttree);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.lefttree);
            postorder(root.righttree);
            System.out.print(root.data);

        }

        public static void Inorder(Node root) {
            if (root == null) {
                return;
            }
            Inorder(root.lefttree);
            System.out.print(root.data);
            Inorder(root.righttree);

        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);
            while (!q.isEmpty()) {
                Node currNode = q.remove();
                if (currNode == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;

                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(currNode.data);
                    if (currNode.lefttree != null) {
                        q.add(currNode.lefttree);
                    }
                    if (currNode.righttree != null) {
                        q.add(currNode.righttree);
                    }

                }
            }

        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.lefttree);
            int rh = height(root.righttree);
            return Math.max(lh, rh) + 1;
        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }
            int leftcount = count(root.lefttree);
            int rightcount = count(root.righttree);
            return (leftcount + rightcount) + 1;
        }

        public static int treediameter(Node root) {
            if (root == null) {
                return 0;
            }
            int leftht = height(root.lefttree);
            int leftdia = treediameter(root.lefttree);
            int rightht = height(root.righttree);
            int rightdia = treediameter(root.righttree);
            int selfdia = leftht + rightht + 1;

            return Math.max(selfdia, Math.max(leftdia, rightdia));

        }

        public static boolean isIdentical(Node node, Node subroot) {
            if (node == null && subroot == null) {
                return true;
            } else if (node == null || subroot == null || node.data != subroot.data) {
                return false;
            }
            if (!isIdentical(node.lefttree, subroot.lefttree)) {
                return false;
            }
            if (!isIdentical(node.righttree, subroot.righttree)) {
                return false;
            }
            return true;
        }

        public static boolean isSubtree(Node root, Node subroot) {
            if (root == null) {
                return false;
            }
            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }
            return isSubtree(root.lefttree, subroot) || isSubtree(root.righttree, subroot);

        }
        static class Info{
            Node node;
            int hd;

           public Info(Node node , int hd){
                this.node = node;
                this.hd = hd;
            }
        }

        public static void Topview(Node node){
            Queue<Info> q = new LinkedList<>();
            HashMap<Integer , Node > map = new HashMap<>();
            int min = 0;
            int max = 0;
            q.add(new Info(node,0));
            q.add(null);
            while(!q.isEmpty()){
                Info curr = q.remove();
                if(curr == null){
                    if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    if(!map.cantainKey(curr.hd)){
                        map.put(curr.hd , curr.node);
                    }
                    if(curr.node.lefttree != null){
                        q.add(new Info(curr.node.lefttree , curr.hd-1));
                        min = Math.min(min , curr.hd-1);
                    }
                    if(curr.node.righttree != null){
                        q.add(new Info(curr.node.righttree , curr.hd+1));
                        max = Math.max(max , curr.hd+1);
                    }
                }
            }
            for(int i = min ; i<=max;i++){
                System.out.print(map.get(i).data);
            }
           
        }
    }

    public static void main(String args[]) {
        Node node = new Node(1);
        node.righttree = new Node(3);
        node.righttree.righttree = new Node(7);
        node.righttree.lefttree = new Node(6);
        node.lefttree = new Node(2);
        node.lefttree.lefttree = new Node(4);
        node.lefttree.righttree = new Node(2);

        Node subroot = new Node(2);
        subroot.lefttree = new Node(4);
      //  subroot.righttree = new Node(5);
        System.out.print(binarytree.isSubtree(node,subroot));
    }

}
