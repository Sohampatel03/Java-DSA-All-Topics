import java.util.*;

public class reversearray{
    public static void update(int mark[]){
      int temp;
     int first = 0,last = mark.length-1;
     while(first<last){
      temp = mark[last];
     mark[last] = mark[first];
      mark[first] = temp;
      first++;
      last--;


     }
  
     
       

          
        }
       
 

    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
      int mark[] = {1,2,3,4,5};
    
     
     update(mark);
     for(int i=0;i<mark.length;i++){
      System.out.print(mark[i]);

     }
      System.out.println();


      
       
        
   

    } 

}
