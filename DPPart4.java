import java.util.*;
public class DPPart4 {

    public static int logestcommonsubstring(String s1 ,  String s2 , int lens1 ,int lens2){
        int dp[][]= new int[lens1+1][lens2+1];
        int ans =0;
        for(int i=1; i<lens1+1;i++){
            for(int j=1;j<lens2;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){//same h  string ke charactor
                    dp[i][j] =  dp[i-1][j-1]+1;//dono stirng me se -1 karenge same h toh or agle wale index ke liye check karenge
                    ans = Math.max(ans,dp[i][j]);//humara jo amswer h or current logest sstring ki oength ko campare kr ke ans me store krva lenge
                }else{//agar same nahi h toh vaspis 0(zero) se logestcommon substring count karenge
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
//ye niche q=wale question ka nam h logest increasing subsequence
    public static int LogestIncSub(int arr[],int lenArr){
        //hashset banaya unique element ke liye
        //kyuki unique element ko sort kr ke logest sunsequence nikalenge toh hume humara answer mil jayega
        HashSet<Integer> set = new HashSet<>();
        //element add in a hashset
        for(int i=0 ; i<lenArr;i++){
            set.add(arr[i]);
        }
        //create array2 for sorted and unique elements
        int arr2[] = new int[set.size()];
        int dp[][] = new int[lenArr+1][arr2.length+1];
        int s=0;
        for(int num : set){
            arr2[s] = num;
            s++;
        }
        Arrays.sort(arr2);
        //same logic we are applying that we apply in string logest subsequence
        for(int i=1; i<lenArr+1;i++){
            for(int j=1; j<arr2.length+1;j++){
                if(arr[i-1] == arr2[j-1]){//same aya toh minus kr ke agle wale ke liye chack kro
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{ // diffrent wala case
                    int ans = dp[i-1][j];//ek bar pehle array ke index ko minus (row)kr ke chaeck kro
                    int ans1 = dp[i][j-1];// ek bar dusre array ke index ko means (clolumn)
                    dp[i][j] = Math.max(ans,ans1);
                }
            }
        }
        return dp[lenArr][arr2.length]; 
    }

    public static int EditDistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        //initialization process
        for(int i=0; i<n+1;i++){
            for(int j=0; j<m+1;j++){
                if(i==0){
                    dp[i][j] = j;
                }
                if(j==0){
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1;i<n+1;i++){
            for(int j=1; j<m+1;j++){//same case
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{//diffrent wala case agar samjh na aaye toh copy me likha h vo dekh lena
                    int add = dp[i][j-1]+1;
                    int delete = dp[i-1][j] +1;
                    int replace = dp[i-1][j-1]+1;
                    dp[i][j] = Math.min(add,Math.min(delete,replace));
                }
            }
        }
        return dp[n][m];
    }
    public static void main(String args[]){
        String s = "intention";
        String s1 = "execution";
        int arr[] = {50,3,10,7,40,80};
        System.out.print(EditDistance(s,s1));
    }
}
