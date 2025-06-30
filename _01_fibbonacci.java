import java.util.Arrays;
public class _01_fibbonacci{
    public static void main(String[] args) {
        int n = 10 ;
        System.out.println("fibbonacci by recusion 2^n : "+fib1(n)) ;

        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println("fibbonacci by dp Memozation : "+fib2(n, dp)) ;

        System.out.println("fibbonacci by dp Tabulation : "+fib3(n)) ;

    }

    // tc : 2^n  recusion
    public static int fib1(int n){
        //base case 
        if(n<=1) return n;

        return fib1(n-1) + fib1(n-2);
    }

    // dp (Top-Down approch) (Memoization)  ||  TC : O(n) && SC : O(n)
    public static int fib2(int n , int []dp){
        //base case 
        if(n<=1){
            dp[n]=n;
            return n ;
        }

        if(dp[n] != -1){     //check store result , if there return it 
            return dp[n];
        }
        dp[n] = fib2(n-1 , dp) + fib2(n-2 , dp);

        return dp[n];
    }

    //dp (Bottom-Up Approch) (Tabulation) ||  TC : O(n) && SC : O(n)
    public static int fib3(int n){
        if(n<=1){
            return n ;
        }

        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}