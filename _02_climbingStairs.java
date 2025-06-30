public class _02_climbingStairs{
    public static void main(String[] args) {
        int n = 15;
        System.out.println("no of ways to reach stair : "+cS1(n));

        System.out.println("no of ways to reach stair : "+cS2(n));

    }

    //dp (Bottom-Up Approch) Tabulation 
    public static int cS1(int n){
        if(n<=2){
            return n;
        }
        
        int dp[] = new int[n+1];
        dp[1]=1;
        dp[2]=2;

        for(int i =3 ; i<=n ; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    // dp optimised than Tabulation
    public static int cS2(int n){
        if(n<=2){
            return n;
        }
        
        int dp[] = new int[n+1];
        int prev2 = 1;
        int prev1 = 2;
        int ans ;
        for(int i =3 ; i<=n ; i++){
            ans = prev1 + prev2;
            prev2 = prev1;
            prev1 = ans;
        }

        return prev1;
    }
    
}