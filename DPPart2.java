import java.util.*;
public class DPPart2 {

    public static int Knapsack(int val[] , int wt[] , int w , int n){
        if(n==0 || w==0){
            return 0;
        }
        if(wt[n-1] <= w){
            //include apne profite ko add kr ke ans me store karvayi value(val[n-1]+....)
            int ans = val[n-1]+Knapsack(val , wt, w-wt[n-1] , n-1);
            //exclude
            int ans2 = Knapsack(val , wt, w , n-1);
            return Math.max(ans , ans2);
        }else{
            return Knapsack(val , wt, w , n-1);
        }  
    }

    //knapsack problem with the DP memoisation approach

    public static int DPKnapsack(int val[] , int wt[] , int w , int n , int dp[][]){
        if(n==0 || w==0){
            return 0;
        }
        if(dp[n][w] != -1){ 
            return dp[n][w];
        }
        if(wt[n-1] <= w){
            //include apne profite ko add kr ke ans me store karvayi value(val[n-1]+....)
            int ans = val[n-1]+DPKnapsack(val , wt, w-wt[n-1] , n-1 ,dp);
            //exclude
            int ans2 = DPKnapsack(val , wt, w , n-1, dp);
           dp[n][w] = Math.max(ans , ans2);
           return dp[n][w];
        }else{
           dp[n][w] = DPKnapsack(val , wt, w , n-1  ,dp);
            return dp[n][w];
        }  
    }

    // ab tabulation wala code 

    public static int Tabknapsack(int val [] , int wt[] , int w){
        int n = val.length;
        int dp[][] = new int[n+1][w+1];
        //ab initializATON
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }
      //  nested loop fill karne ke liye dp array ko
        
        for(int i=1; i<n+1;i++){
            for(int j=1; j<w+1; j++){
                int value = val[i-1];
                int weight = wt[i-1];
                //ab valid condition or invalid condition dekh ke initialize karenge
                if(weight <=j){//valid
                    int includeprofit = value + dp[i-1][j-weight];
                    int excludeprofit = dp[i-1][j];
                    dp[i][j] = Math.max(includeprofit , excludeprofit);
                }else{//unvalid condition
                    int excludeprofit = dp[i-1][j];
                    dp[i][j] = excludeprofit;
                }
            }
        } 
        return dp[n][w];
    }

    //public static int Targetsum(int arr[] , int sum){
    //int n = arr.length;
    //    int dp[][] = new int[n+1][sum+1];
    //    for(int i=0; i<)
    //}

    public static int UnboundedKnapsack(int val[] , int wt[], int w){
        int n = val.length;
        int dp[][] = new int[n+1][w+1];
        //ab initializATON
        for(int i=0; i<dp.length; i++){
            dp[i][0] = 0;
        }
        for(int j=0; j<dp[0].length; j++){
            dp[0][j] = 0;
        }
      //  nested loop fill karne ke liye dp array ko
        
        for(int i=1; i<n+1;i++){
            for(int j=1; j<w+1; j++){
                int value = val[i-1];
                int weight = wt[i-1];
                //ab valid condition or invalid condition dekh ke initialize karenge
                if(weight <=j){//valid
                    int includeprofit = value + dp[i][j-weight];
                    int excludeprofit = dp[i-1][j];
                    dp[i][j] = Math.max(includeprofit , excludeprofit);
                }else{//unvalid condition
                    int excludeprofit = dp[i-1][j];
                    dp[i][j] = excludeprofit;
                }
            }
        } 
        return dp[n][w];
    }


    public static void main(String args[]){
        int val[] = {15,14,10,45,30};
        int wt[] = {2,5,1,3,4};
        int w = 7; 
        System.out.print(UnboundedKnapsack(val,wt,w));
    }
    
}
