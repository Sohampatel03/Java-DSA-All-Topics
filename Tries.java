public class Tries {
    public static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

        public static Node root = new Node();

        public static void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (curr.children[idx] == null) {
                    curr.children[idx] = new Node();
                }
                curr = curr.children[idx];
            }
            curr.eow = true;
        }

        public static boolean search(String key){
            Node curr = root;
            for(int i = 0 ; i<key.length(); i++){
                int idx = key.charAt(i) - 'a';
                if(curr.children[idx] == null){
                    return false;
                }
                curr = curr.children[idx];
            }
            return curr.eow == true;
        }

        public static boolean wordbreak(String key){
            //base case
            if(key.length() == 0){
                return true;

            }
            for(int i = 1 ; i<key.length(); i++){
                // ye if condition me pehle to search karega substring me then and and bad vo 
                //substring ko recursivly or substring me divide kr ke search karega
                if(search(key.substring(0,i)) && wordbreak(key.substring(i))){
                    return true;
                }
            }
            return false;
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
                }
            }
        }
    

    public static void main(String args[]) {      // 0(l)   l=level
       // String word[] = { "the", "a", "there", "their" };
       String word[] = {"a" , "banana" , "app" , "appl" , "apple" , "apply" , "ap"};
        String key = "th";
        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }
        LogestWord(root ,new StringBuilder(""));
        System.out.print(ans); 
 
       // boolean ans =;
      //  System.out.print( search(key));

    }
}