
import java.util.Arrays;

public class _04_minCostClimbingStair {

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int n = cost.length;
        System.out.println("min cost rec : " + rec(n, cost));

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("min cost dp Memo : " + dpM(n, cost, dp));

        System.out.println("min cost dp Tabu : " + dpT(n, cost));

        System.out.println("min cost dp Optimised : " + dpO(n, cost));
    }

    //recusion approch 
    public static int rec(int n, int cost[]) {
        if (n == 0 || n == 1) {
            return 0;
        }

        int oneStep = cost[n - 1] + rec(n - 1, cost);
        int secStep = cost[n - 2] + rec(n - 2, cost);

        return Math.min(oneStep, secStep);
    }

    // top down Approch (Memoization)
    public static int dpM(int n, int[] cost, int[] dp) {
        if (n == 0 || n == 1) {
            dp[n] = 0;
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int oneStep = cost[n - 1] + dpM(n - 1, cost, dp);
        int secStep = cost[n - 2] + dpM(n - 2, cost, dp);

        dp[n] = Math.min(oneStep, secStep);
        return dp[n];
    }

    //bottom up (Tabulation)
    public static int dpT(int n, int[] cost) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int oneStep = cost[i - 1] + dp[i - 1];
            int secStep = cost[i - 2] + dp[i - 2];
            dp[i] = Math.min(oneStep, secStep);
        }

        return dp[n];
    }
    //bottom up (Tabulation)
    public static int dpO(int n, int[] cost) {
        int[] dp = new int[n + 1];
        int prev2 = 0;
        int prev1 = 0;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            int oneStep = cost[i - 1] + prev1;
            int secStep = cost[i - 2] + prev2;
            ans = Math.min(oneStep, secStep);
            prev2 = prev1 ;
            prev1 = ans;
        }

        return prev1;
    }
}
