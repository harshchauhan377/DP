import java.util.Arrays;

public class _16_longestIncreasingSubsequence{
    public static void main(String[] args){
        int nums[] = {10,9,2,5,3,7,101,18};
        int n = nums.length;
        System.out.println("dpT : "+lengthOfLIS(nums));

        System.out.println("rec : "+rec(0 , -1 , nums , n));

        int dp[][] = new int[n][n+1]; // prev + 1 bcoz ham prev -1 nahi kar sakte tho use prev == 1 ;
        for(int i = 0 ; i< n ; i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println("dpM : "+dpM(0 , -1 , nums , n , dp));
    }

    public static int rec(int i , int prev , int[]arr , int n){
        if(i==n){
            return 0 ;
        }

        int pick = 0 ;
        if(prev == -1 || arr[i]> arr[prev] ){
            pick = 1 + rec(i+1 , i , arr , n);
        }

        int nonPick = 0 + rec(i+1 , prev , arr , n);

        return Math.max(pick , nonPick);
    }

    public static int dpM(int i , int prev , int[]arr , int n , int dp[][]){
        if(i==n){
            return 0 ;
        }

        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }

        int pick = 0 ;
        if(prev == -1 || arr[i]> arr[prev] ){
            pick = 1 + dpM(i+1 , i , arr , n , dp);
        }

        int nonPick = 0 + dpM(i+1 , prev , arr , n , dp);

        dp[i][prev+1] = Math.max(pick , nonPick);
        return dp[i][prev+1];
    }

    //tabulation bottom up approch
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        Arrays.fill(dp,1);

        int maxL = 1 ;
        for(int i = 1; i< n ; i++){
            for(int j = 0; j< i ; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i] , 1 + dp[j]);
                }
            }
            if(dp[i] > maxL){
                maxL = dp[i];
            }
        }
        return maxL;

    }
}