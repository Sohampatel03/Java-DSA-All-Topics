import java.util.*;
public class Heapdsa {

     static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            arr.add(data);//add data at the last index
            int x = arr.size()-1;//last index value
            int parent = (x-1)/2;//parent value

            while(arr.get(parent) > arr.get(x)){
                //swap
                int temp = arr.get(x);
                arr.set(x,parent);
                arr.set(parent , temp);
                //update the value of variables
                x = parent ; 
                parent = (x-1)/2;
            }
        }
        public int pick(){
            return arr.get(0);
        }
        public boolean isEmpty(){
            return arr.size() == 0;
        }

        private void heapify(int i){
            int left = 2*i+1;
            int right = 2*i+2;
            int mididx = arr.get(0);

            if(left < arr.size() && arr.get(mididx) > arr.get(left)){
                mididx = left;
            }
            if(right < arr.size() && arr.get(mididx) > arr.get(right)){
                mididx = right;
            }

                if(mididx != i){
                    //that there we have to change so we can swap 
                int temp = arr.get(i);
                arr.set(i , arr.get(mididx));
                arr.set(mididx , temp);

                heapify(mididx );
                }
            
            }
        

        public int remove(){
            int data = arr.get(0);
            //swap the values

            int temp = arr.get(0);
            arr.set(0,arr.get(arr.size()-1));
            arr.set(arr.size()-1 , temp);

            //call heapify for arrange the tree
            heapify(0);
            return data;

        }
    }
    }
    

