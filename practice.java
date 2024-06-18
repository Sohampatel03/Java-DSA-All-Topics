import java.util.*;
public class practice {
    public static int getith(int n , int i){
        int bitmask = (i<<1);
        if( (n & bitmask) == 0){
            return 0;
        } 
        else{
            return 1;
        }
    }

    public static int setith(int n, int i){
        int bitmask = (i<<1);
        int ans = (n | bitmask ); 
    return ans;   }

    public static int clearith(int n , int i){
   int bitmask = ~(i<<1);
   int ans = (n&bitmask);
   return ans;
    }

    public static int updateith(int n ,int i, int newbit){
        if (newbit == 0) {
            return clearith(n ,i);
            
        }else{
            return setith(n,i);
        }
    }

    public static int clearlastith(int n , int i){
        int bitmask = (-1 << i);
        int ans = n & bitmask;
        return ans;
    }

    public static int countsetbit(int n){
        int count =0;
        while(n>0){
            if((n&1) != 0){
                count++;
            }
            n = n>>1;
        }
        return count;
    }

    public static int fastexponential(int a,int n){
        int ans = 1;
        while(n>0){
            if((n&1) != 0){
                ans = a*ans;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }

    public static boolean powerofbit(int n){
        return (n&(n-1)) == 0;
    }


    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
       
    System.out.print(powerofbit(0));
      
          
    if (arr == null || m < 0 || m >= arr.size()) {
        // Handle invalid input
        return;
    }

    int start = 0;
    int end = m;

    while (start < end) {
        // Swap elements at positions 'start' and 'end'
        int temp = arr.get(start);
        arr.set(start, arr.get(end));
        arr.set(end, temp);

        start++;
        end--;
    }
    
}
public class Solution {
    public static void cal(int arr[],int n){
        if(n==0 || n==1){
            return n;
        }
        arr[]
    }
    public static int[] generateFibonacciNumbers(int n) {
       arr= new int[n];
       cal(arr,n)
       return arr;   
    }
}