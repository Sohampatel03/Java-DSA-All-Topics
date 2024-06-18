import java.util.*;

public class DPPart3 {

    public static int CoinChange(int val[], int w) {
        int n = val.length;
        int dp[][] = new int[n + 1][w + 1];
        // ab initializATON
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
        // nested loop fill karne ke liye dp array ko

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                int value = val[i - 1];

                // ab valid condition or invalid condition dekh ke initialize karenge
                if (val[i - 1] <= j) {// valid
                    int includeprofit = dp[i][j - val[i - 1]];
                    int excludeprofit = dp[i - 1][j];
                    dp[i][j] = includeprofit + excludeprofit;
                } else {// unvalid condition
                    int excludeprofit = dp[i - 1][j];
                    dp[i][j] = excludeprofit;
                }
            }
        }
        return dp[n][w];

    }

    public static int RodCutting(int price[], int length[], int TotalRodLen) {
        int dp[][] = new int[price.length + 1][TotalRodLen + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;

        }

        for (int i = 1; i < price.length + 1; i++) {
            for (int j = 1; j < TotalRodLen + 1; j++) {
                if (length[i - 1] <= j) {
                    // include
                    int includelen = price[i - 1] + dp[i][j - length[i - 1]];
                    // exclude
                    int excludelen = dp[i - 1][j];
                    dp[i][j] = Math.max(includelen, excludelen);
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }

        }
        return dp[price.length][TotalRodLen];
    }

    public static int LogestSubSequnce(String s1, String s2 , int lens1 , int lens2){
        if(lens1 == 0 || lens2 == 0){
            return 0;
        }
        if(s1.charAt(lens1-1) == s2.charAt(lens2-1)){//agar same charactor h toh dono ki length minus kr ke resursion call kr do
           return  LogestSubSequnce(s1,s2,lens1-1,lens2-1)+1;
        }else{//not same wala case
           int left = LogestSubSequnce(s1,s2,lens1-1,lens2);
            int right =LogestSubSequnce(s1,s1,lens1,lens2-1);
            return Math.max(left,right);
        }
    }
    //same question but memoisation or dp version me logestsunsequence

    public static int MemoiLogestSubSequnce(String s1,String s2 , int lens1, int lens2 ,int dp[][]){
        if(lens1 == 0 || lens2 == 0){
            return 0;
        }
        if(dp[lens1][lens2] != -1){
            return dp[lens1][lens2];
        }
        if(s1.charAt(lens1-1) == s2.charAt(lens2-1)){//agar same charactor h toh dono ki length minus kr ke resursion call kr do
           return   dp[lens1][lens2]=MemoiLogestSubSequnce(s1,s2,lens1-1,lens2-1,dp)+1;
        }else{//not same wala case
           int left = MemoiLogestSubSequnce(s1,s2,lens1-1,lens2,dp);
            int right =MemoiLogestSubSequnce(s1,s1,lens1,lens2-1,dp);
            return dp[lens1][lens2] =Math.max(left,right);
        }

    }

    //ab tabualtion wala code  LogestSubSequnce
    public static int TabLogestSubSequnce( String s1 , String s2 , int l1 , int l2){
        int dp[][] = new int[l1+1][l2+1];
        //dp array ke liye pehle row and colounm me 0 ko intialize krna jaruri h java me pehle se hi ho jata h is liye nahi kr rahe h
        
        
        for (int i = 1; i < l1 + 1; i++) {
            for (int j = 1; j < l2 + 1; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){//same wali condition
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{//difrence wali condition
                    int ans1 = dp[i-1][j]; 
                    int ans2 = dp[i][j-1];
                    dp[i][j] = Math.max(ans1,ans2);
                }
            }
        }
        return dp[l1][l2];
    }

    public static void main(String args[]) {
        int val[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
        int len[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int sum = 8;
        String s = "abcderty";
        String s1 = "abedg";
        int dp[][] = new int[s.length()+1][s1.length()+1];
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<s1.length()+1;j++){
                dp[i][j] =-1;
            }
        }
        System.out.print(TabLogestSubSequnce(s,s1,s.length(),s1.length()));
        System.out.print(RodCutting(val, len, sum));

    }

}
