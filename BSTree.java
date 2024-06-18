import java.util.*;
public class BSTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

        public static Node insert(Node root, int val) {
            if (root == null) {
                //kuch nahi h toh val ka ek root banake return kr dete h
                root = new Node(val);
                return root;
            }
            if (root.data > val) {
                //agar choti h toh left tree me add kr denge 
                root.left = insert(root.left, val);
            } else {
                // or agar badi h toh right tree me add rk denge
                root.right = insert(root.right, val);
            }
            return root;
        }
        // this function is for print the tree
        public static void Inorder(Node root){
            if(root == null){
                return;
            }
            Inorder(root.left);
            System.out.print(root.data);
            Inorder(root.right);
        }
          // this function is for print the tree
          public static void preorder(Node root){
            if(root == null){
                return;
            }
            System.out.print(root.data);
            preorder(root.left);
            preorder(root.right);
        }

        public static boolean search(Node root , int key){
            if(root == null){
                return false;
            }
               // agar data  key ke equal h to return true
            if(root.data == key){
                return true;
            }
          //agar data chota h toh hum left me search karenge
            if(root.data > key){
                return search(root.left , key);
            }else{
                // agar data bada h toh humm right me search karenge
                return search(root.right , key);
            }
        }
            public static void printInrange(Node root , int k1 , int k2){
                if(root == null){
                    return;
                }
                if(root.data <= k1 && root.data <= k2){
                    printInrange(root.left , k1 , k2);
                    System.out.print(root.data);
                    printInrange(root,k1 , k2);
                }else if(root.data < k1 ){
                    printInrange(root.left , k1 ,k2);
                }else{
                    printInrange(root.right , k1 ,k2);
                }
            }

            public static boolean isValidBST(Node root , Node min  , Node max){
            if(root == null){
                return true;
            }
            //isme agar root per jo data h vo minimum se chota h toh return false
            if(min != null && root.data <= min.data){
                return false;
            }
            //isme agar root ka data maximun=m se bada h toh return false
            else if(max != null && root.data >= max.data){
                return false;
            }
            //or yaha recursevly hum jab tak call karenge tab tak null nahi jo jata ya
            // false condition nai aati
            return isValidBST(root.left , min , root) && isValidBST(root.right , root , max);
            }


            public static Node CreateMirror(Node root){
                if(root == null){
                    return null;
                }
                //left or right tree create kiya recursion me then backtrack me swap
                Node leftMirror = CreateMirror(root.left);
                Node rightMirror = CreateMirror(root.right);
                //backtrack krte time swaping kr rahe h 
                root.left = rightMirror;
                root.right = leftMirror;
                //return root of mirror tree
                return root;
            }

            public static Node CreateBST(int arr[] , int st , int end){
                if(st > end){
                    return null;
                }
                int mid = (st + end) / 2;
                Node root = new Node(arr[mid]);
                root.left = CreateBST(arr,st,mid-1);
                root.right = CreateBST(arr,mid+1 ,end);
                return root;
            }
            //these create Bst is for the arraylist argument
            public static Node createBST(ArrayList<Integer> arr , int st , int end){
                if(st > end){
                    return null;
                }
                int mid = (st + end) / 2;
                Node root = new Node(arr.get(mid));
                root.left = createBST(arr,st,mid-1);
                root.right = createBST(arr,mid+1 ,end);
                return root;
            }

            public static void getInorder(Node root , ArrayList<Integer> arr){
                if(root == null){
                    return;
                }
                getInorder(root.left , arr);
                arr.add(root.data);
                getInorder(root.right , arr);

            }


            public static Node Merge2BSt(Node root1 , Node root2){
                //step 1
                ArrayList<Integer> arr1 = new ArrayList<>();
                getInorder(root1 , arr1);

                //step2
                ArrayList<Integer> arr2 = new ArrayList<>();
                getInorder(root2 , arr2);

                //step 3
                ArrayList<Integer> finalArr = new ArrayList<>();
                int i = 0 ; int j = 0;
                while(i<arr1.size() && j<arr2.size()){
                    if(arr1.get(i) <= arr2.get(j)){
                        finalArr.add(arr1.get(i));
                        i++;
                    }else{
                        finalArr.add(arr2.get(j));
                        j++;
                    }
                    //remaining element another while loops
                    while(i < arr1.size()){
                        finalArr.add(arr1.get(i));
                        i++;
                    }
                    while(j < arr2.size()){
                        finalArr.add(arr2.get(j));
                        j++;
                    }
                }
                return createBST(finalArr , 0 , finalArr.size()-1);
            }
        
    

    public static void main(String agrs[]) {
       // int val[] = {10,8,6,4,2,1,3,5,7,9};
       // Node root = null;
       // 
       // for (int i = 0; i < val.length; i++) {
       //     root =insert(root, val[i]);
       // }
       Node node1 = new Node(8);
        node1.left= new Node(5);
        node1.right = new Node(10);
       // node.left.left = new Node(3);
       // node.left.right = new Node(6);
       // node.right.right = new Node(11);
       Node node2 = new Node(1);
       node2.left = new Node(2);
       node2.right = new Node(3);

      
       

    }
}
