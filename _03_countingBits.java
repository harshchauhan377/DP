public class _03_countingBits{
    public static void main(String[] args) {
        int n = 5;
        int []arr = countBits(n);
        for(int i = 0; i<arr.length ; i++){
            System.out.print(arr[i]+" ");
        }
    }

    // TC : O(n)
    public static int[] countBits(int n) {
        int dp[] = new int[n+1];
        for(int i = 1 ; i<= n ; i++){
            dp[i] = dp[i>>1] + (i&1);
        }
        return dp;
    }
}