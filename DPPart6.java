import java.util.*;
public class DPPart6 {

    public static int MinimumPartation(int arr[]){//0(n*w)
        int n = arr.length;
        int sum =0;
        for(int i=0; i<n;i++){
            sum += arr[i];
        }
        int w = sum/2;
        int dp[][]= new int[n+1][w+1];

        for(int i=1; i<n+1;i++){
            for(int j=1;j<w+1;j++){
                if(arr[i-1]<=j){//valid
                                            //include!                  //exclude!
                    dp[i][j] = Math.max(arr[i-1]+dp[i-1][j-arr[i-1]] , dp[i-1][j]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int sum1= dp[n][w];
        int sum2= sum-sum1;
        return Math.abs(sum1-sum2);
    }

    public static int MinimumArrayJumps(int arr[]){
        int n = arr.length;
        int dp[] = new int[n];
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        dp[n-1]= 0;
        
        for(int i=n-2;i>=0;i--){
            int ans = Integer.MAX_VALUE;
            int step = arr[i];
            for(int j=i+1;j<=1+step && j<n; j++){
                if(dp[j] != -1){
                    ans  = Math.min(ans,dp[j]+1);
                }
            }
            if(ans != Integer.MAX_VALUE){
                dp[i] = ans;
            }
        }
        return dp[0];
    }
    public static void main(String args[]){
        int arr[] = {2,3,1,1,4};
       System.out.println(MinimumArrayJumps(arr));
    }
}
