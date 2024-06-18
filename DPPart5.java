import java.util.*;
public class DPPart5 {

    public static boolean WildCard(String s, String s2) {
        int n = s.length();
        int m = s2.length();
        boolean dp[][] = new boolean[n + 1][m + 1];
        // first case jab dono string empty ho toh true
        dp[0][0] = true;
        // second case jab string ho but pattern zero ho means empty toh false
        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = false;
        }
        // third case jab string star ho toh jo pehle store tha true ya false vo store
        // ho gaye
        for (int i = 1; i < m + 1; i++) {
            if (s2.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 1];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // agar ith charactor equal h jth charactor se or jth charactor equal h ? se toh
                // dono -1 ho gayenge
                if (s.charAt(i - 1) == s2.charAt(j - 1) || s2.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } // else if me agar pattern me * h toh ignore kr do ya toh last charactor se
                  // match kr do to jo dp[i-1][j] ye wala case last charactor se match krta h or
                  // jo dp[i][j-1] wala case ye ignore krne ka kam krta h
                else if (s2.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];

    }
//this is a catalna resursion code

    public static int catalan(int n){
        if(n== 0 || n==1){
            return 1;
        }
        int ans = 0;
        for(int i=0 ; i<=n-1;i++){
            ans += catalan(i) * catalan(n-i-1);
        }
        return ans;
    }
//this is a catalan memoisation code in dp

public static int catalanRec(int n,int dp[]){
    Arrays.fill(dp,-1);
    if(n== 0 || n==1 ){
        return 1;
    }
    if(dp[n] != -1){
        return dp[n];
    }
    int ans =0;
    for(int i=0; i<=n-1;i++){
        ans += catalanRec(i,dp) * catalanRec(n-i-1,dp);
    }
    
    return dp[n] = ans;
}

//this is catalan tabulation code

public static int TabCatalan(int n){
    int dp[]= new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<n+1;i++){
        for(int j=0 ; j<i;j++){
            dp[i] += dp[j] * dp[i-j-1];
        }
    }
    return dp[n];
}
//count BST wale question me same catalan ka logic or same to same code use hoga

public static int CountBST(int n){
    int dp[]= new int[n+1];
    dp[0] = 1;
    dp[1] = 1;
    for(int i=2; i<n+1;i++){
        for(int j=0 ; j<i;j++){
           int left = dp[j] ;//left tree
           int right = dp[i-j-1];//right tree
           dp[i] += left*right;
        }
    }
    return dp[n];

}
public static void main (String args[]){
    String s = "abcasdfghjserjhawdfg";
    String s2 = "abs?";
    int n =4;
    int dp[] = new int[n+1];
   System.out.println(TabCatalan(4)); 
   //System.out.println(catalanRec(4 ,dp)); 
}
}


