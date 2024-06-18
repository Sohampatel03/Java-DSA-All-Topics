public class PrifixProblem {
    public static class Node{
        Node[] children = new Node[26];
        boolean eow = false;
        int freq;

        public Node(){
            for(int i = 0 ; i<children.length;i++){
                children[i] = null;
            }
            freq = 1;
        }
    }
    public static Node root = new Node();

    public static void insert(String word){
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }else{
                curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;

    }

    public static void FindPrifix(Node root , String ans){
        if(root == null){
            return ;
        }
        if(root.freq == 1){
            System.out.print(ans);
            return;
        }

        for(int i =0; i<root.children.length;i++){
            if(root.children[i] != null){
                FindPrifix(root.children[i] , ans + (char)(i +'a'));
            }

        }

    }
    public static String ans = "";
    public static void LogestWord(Node root , StringBuilder temp){
        if(root == null){
            return;
        }
        for(int i=0; i<26; i++){
            if(root.children[i] != null && root.children[i].eow == true){
                char ch = (char) (i+'a');
                temp.append(ch);
                if(temp.length() > ans.length()){
                    ans = temp.toString();
                }
                LogestWord(root.children[i] , temp);
                temp.deleteCharAt(temp.length()-1);//backtrack step
            }
        }
    }
    public static void main(String args[]){
    String word[] = {"a" , "banana" , "app" , "appl" , "apple" , "apply" , "ap"};
        for(int i = 0 ; i<word.length;i++){
            insert(word[i]);
        }

       LogestWord(root ,new StringBuilder(""));
       System.out.print(ans); 

        //root.freq = -1;
       // FindPrifix(root , ans);
    }

    
}
