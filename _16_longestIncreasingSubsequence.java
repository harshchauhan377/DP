import java.util.Arrays;

public class _16_longestIncreasingSubsequence{
    public static void main(String[] args){
        int nums[] = {10,9,2,5,3,7,101,18};
        System.out.println("dpT : "+lengthOfLIS(nums));
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