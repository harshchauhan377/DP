public class _11_coinChange2{
    public static void main(String[] args) {
        int coins[] = {1,2,5};
        int amount = 5 ;

        System.out.println("dpT : "+dpT(coins,amount));
    }
    public static int dpT(int coins[] , int amount){
        int n = coins.length;
        int dp[][] = new int[n][amount + 1];

        // base case 
        for(int a = 0 ; a < amount + 1 ; a++){
            if(a % coins[0] == 0){
                dp[0][a]=1;
            }else{
                dp[0][a]=0;
            }
        }

        for(int i = 1 ; i<n ; i++){
            for(int a = 0 ; a < amount + 1 ; a++){
                int pick = 0 ;
                if(coins[i]<=a){
                    pick = dp[i][a - coins[i]];
                }
                int nonPick = dp[i-1][a];
                dp[i][a] = pick + nonPick ;
            }
        }

        return dp[n-1][amount];
    }
}
