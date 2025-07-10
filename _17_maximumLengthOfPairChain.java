import java.util.Arrays;

public class _17_maximumLengthOfPairChain {
    public static void main(String[] args) {
        int[][] pairs = { {1, 2}, {2, 3}, {3, 4} };
        System.out.println("dpT : "+findLongestChain(pairs));
    }

    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> a[0] - b[0]); // Sort by start

        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxL = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            maxL = Math.max(maxL, dp[i]);
        }

        return maxL;
    }
}
