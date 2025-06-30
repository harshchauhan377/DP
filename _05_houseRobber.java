import java.util.Arrays;
public class _05_houseRobber{
    public static void main(String[]args){
        int[]nums={7,1,1,6,1};
        int n = nums.length;
        System.out.println("rec : "+rec(nums,n-1));

        int dp[]= new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("dpM : "+dpM(nums,n,dp));

        System.out.println("dpT : "+dpT(nums,n));

        System.out.println("dpT : "+dpO(nums,n));

    }
    public static int rec(int nums[],int index){
        if(index==0){
            return nums[0];
        }
        if(index==-1){
            return 0;
        }

        int pick = nums[index] + rec(nums,index-2);
        int nonPick = 0 + rec(nums,index-1);
        return Math.max(pick , nonPick);
    }

    public static int dpM(int nums[],int index , int dp[]){
        if(index==1){
            dp[index]=nums[0];
            return nums[0];
        }
        if(index==0){
            dp[index]=0;
            return 0;
        }

        if(dp[index]!=-1){
            return dp[index];
        }

        int pick = nums[index-1] + dpM(nums,index-2,dp);
        int nonPick = 0 + dpM(nums,index-1,dp);
        dp[index] = Math.max(pick , nonPick);

        return dp[index];
    }

    public static int dpT(int[]nums , int n){
        int dp[] = new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];

        for(int i = 2 ; i <=n ; i++){
            int pick = nums[i-1] + dp[i-2];
            int nonPick = 0 + dp[i-1];
            dp[i] = Math.max(pick , nonPick);
        }
        return dp[n];
    }

    public static int dpO(int[]nums , int n){
        if(n==1){
            return nums[0];
        }
        int prev2=0;
        int prev1=nums[0];
        int ans = 0;
        for(int i = 2 ; i <=n ; i++){
            int pick = nums[i-1] + prev2;
            int nonPick = 0 + prev1;
            ans = Math.max(pick , nonPick);
            prev2 = prev1;
            prev1 = ans;
        }
        return ans;
    }
}