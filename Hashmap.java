import java.util.*;
public class Hashmap {

    /*static class Haspmap1<K,V> {
        private class Node{
            K key;
            V value;

           private void node(K key , V value){
                this.key = key;
                this.value = value;
            }
        }
         private int size = 0;
        private LinkedList<Node> buckets[];
        @SuppressWarnings("unchecked")

        public void HashMap(){
            this.size = size;
            this.buckets = new LienkedList[4];
            for(int i = 0 ; i <4;i++){
                this.buckets[i] = new LinkedList<>();
            }
        }

    }
*/
    public static void MajorityElement(int arr[]){
        HashMap<Integer , Integer> hm = new HashMap<>();
        for(int i = 0 ; i<arr.length; i++){
            if(hm.containsKey(arr[i])){
                //yaha humne same key add krdi but increse frquency by +1
                hm.put(arr[i] , hm.get(arr[i])+1);
            }else{
                hm.put(arr[i] , 1);
            }

        } 

        Set<Integer> key = hm.keySet();
        for(Integer k : key){
            if(hm.get(k) > arr.length/3){
                System.out.print(k);
            }
        }
        
    }

    public static int GetStartPoint(HashMap<String , String> tickets){
        HashMap<String, String > ReverseMap = new HashMap<>();
        for(String key : tickets.keySet()){
            ReverseMap.put(tickets.get(key) , key);
        }
        for(String key : tickets.ketSet()){
            if(!ReverseMap.containsKey(key)){
                return key;
            }

        }
        return null;
    }
    public static boolean ValidAnagram(String s, String p){
        HashMap<Charactor , Integer> hm = new HashMap<>();

        for(int i =0; i< s.length(); i++ ){
           char ch = s.charAt(i);
           hm.put(ch,hm.getorDefault(ch,0)+1);
        }
        
    }
    public static void main(String args[]){
       // HashMap<String , Integer> hm = new HashMap<>();
//
       // hm.put("soham" , 1);
       // hm.put("sunil" , 2);
       // hm.put("tejas" , 6);
       // hm.put("tushar" , 4);
       // System.out.print(hm.get("sunil"));
    //System.out.print(hm);
   // Set<String> keys = hm.keySet();
   // System.out.println(keys);
   //  for(String ke : keys){
   //     System.out.print(ke+"-"+hm.get(ke));
   //  }
int arr[] = {1,3,2,5,1,3,1,5,1};
   MajorityElement(arr);
    }
    
}
