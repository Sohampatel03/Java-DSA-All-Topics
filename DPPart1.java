import java.util.*;
public class DPPart1 {

    public static int fibbonacci(int n , int f[]){//0(n) or pehle recursion me rehti thi 0(2^);
        //dp ka concept ye h isme ki value ko store kr ke re use kr lete h recursion me 
        if(n ==0 || n ==1){
            return n;
        }
        if(f[n] != 0){
            return f[n];
        }
        f[n] = fibbonacci(n-1 , f) + fibbonacci(n-2 , f);
        return f[n];
    }

    public static int ClimbingStair(int n , int dp[]){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = ClimbingStair(n-1 , dp) + ClimbingStair(n-2 , dp) +ClimbingStair(n-3 , dp) ;
        return dp[n];
    }
    //ClimbingStair question solution with the debulation approach

    public static int TabClimbingStair(int  n){
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            if(i == 1){
                dp[i] = dp[i-1] ;
            }else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }
        return dp[n];

    }

    public static void main(String args[]){
       
       
        System.out.println( TabClimbingStair(4));

    }
    
}
