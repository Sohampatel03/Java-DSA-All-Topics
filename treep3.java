import java.util.*;
public class treep3 {
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

        public static void treek(Node root , int level ,int  k){
            if(root == null){
                return;
            }
            if(root.data == k){
                System.out.print(root.data);
                return;
            }
            treek(root.lefttree , level+1 , k);
            treek(root.righttree , level+1 , k); 
        }

        public static boolean getpath(Node root , ArrayList<Node> path , int n){
            if(root == null){
                return false;
            }
            path.add(root);
            if(root.data == n){
                return true;
            }
           boolean left =  getpath(root.lefttree , path , n);
           boolean right = getpath(root.righttree , path , n);

           if(left ||  right){
            return true;
           }
           path.remove(path.size() -1);
           return false;
        }
        public static Node lowestcommonA(Node root , int n1, int n2){
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getpath(root , path1 , n1);
            getpath(root , path2 , n2);
            int i;
            for( i =0; i<path1.size() && i<path2.size(); i++){
                if(path1.get(i) != path2.get(i)){
                    break;
                }
            }
            Node lca = path1.get(i-1);
            return lca;
        }

        public static Node lca2(Node root , int n1 , int n2){
            //base case
            if(root == null || root.data == n1 || root.data == n2){
                return root;
            }
            //recursivly call the lca 2 for calculate valid node
            Node leftlca = lca2(root.lefttree , n1 , n2);
            Node rightlca = lca2(root.righttree , n1 , n2);
        //if condition for check the nodes n1 and n2 is exist or not in the valid nodes
            if(leftlca == null){
                return rightlca;
            }
            if(rightlca == null){
                return leftlca;
            }
            return root;
        }

        public static int lcaDist(Node root , int n){
            //base case
            if(root == null){
                return -1;
            }
            if(root.data == n){
                return 0;
            }
            //recurcivly call for calculate left and right tree nodes
            int lcaleft = lcaDist(root.lefttree , n);
            int lcaright = lcaDist(root.righttree , n);
            //condition for check the n is exist or not and if the exist then where the left or right

            if(lcaleft == -1 && lcaright == -1){
                return -1;
            }else if(lcaleft == -1){
                return lcaright+1;
            }else{
                return lcaleft+1;
            }
        }

        public static int minDist(Node root , int n1 , int n2){
            //calculate the lca first
            Node lca = lca2(root , n1 , n2);
            //calculate the distance from the lca to node n1 and node n2

            int leftdis = lcaDist(root , n1);
            int rightdis = lcaDist(root , n2);
            //combine the distance and retuurn as a minimun distance of between the two nodes

            return leftdis + rightdis;        

        }

        public static int KthAncestor(Node root , int n1 , int k){
            if(root == null){
                return -1;
            }
            if(root.data == n1){
                return 0;
            }
            int left = KthAncestor(root.lefttree , n1 , k);
            int right = KthAncestor(root.righttree , n1 , k);

            if(left == -1 && right == -1){
                return -1;
            }
            int max = Math.max(left , right);
            if(max+1 == k){
                System.out.print(root.data);
            }
        return max+1;
        }
        public static int transformsumtree(Node root){
            if(root == null){
                return 0;
            }
            //calculate lefttree and righttree
            int left = transformsumtree(root.lefttree);
            int right = transformsumtree(root.righttree);
            //there is condition for check when we in the leaf node then return 0

            int newleft = root.lefttree == null ? 0 : root.lefttree.data;
            int newright = root.righttree == null ? 0 : root.righttree.data;
            //store data for return
           int data = root.data;
            root.data = newleft + left + right + newright;
            return data;

        }
        public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.println(root.data);
            preorder(root.lefttree);
            preorder(root.righttree);
        }
    }

    public static void main(String args[]){
        
        Node node = new Node(1);
        node.lefttree= new Node(2);
        node.righttree = new Node(3);
        node.lefttree.lefttree = new Node(4);
        node.lefttree.righttree = new Node(5);
        node.righttree.lefttree = new Node(6);
        node.righttree.righttree = new Node(7);

        binarytree.transformsumtree(node);
        binarytree.preorder(node);


    

        
    }

    
}
