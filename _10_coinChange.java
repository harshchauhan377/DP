public class _10_coinChange{
    public static void main(String[] args){
        int[] coins = {1,2,5};
        int amount = 11;
        int n = coins.length;

        //rec 
        int res1 = rec(coins , amount , n-1 );
        if(res1 == (int)(1e9)){
            System.out.println("-1");
        }else{
            System.out.println(" rec : "+res1);
        }

        // memeoization top down approch 
        int dp[][] = new int[n][amount+1];
        for(int i=0; i<n; i++){
            for(int j=0 ; j<amount+1 ; j++){
                dp[i][j] = -1;
            }
        }
        int res2 = dpM(coins , amount , n-1 , dp );
        if(res2 == (int)(1e9)){
            System.out.println("-1");
        }else{
            System.out.println(" dpM : "+res1);
        }

        // tabulation bottom up approch 
        System.out.println(" dpT : "+ dpT(coins, amount));
    }

    public static int rec(int[] coins , int amount , int index ){
        if(index == 0){
            if(amount % coins[index]==0){
                return amount / coins[index] ;
            }
            return (int)(1e9);
        }

        int pick = (int)(1e9);
        if(coins[index] <= amount){
            pick = 1 + rec(coins , amount - coins[index] , index);
        }
        int nonPick = 0 + rec(coins , amount , index -1 );

        return Math.min(pick , nonPick);
    }

    public static int dpM(int[] coins , int amount , int index , int dp[][]){
        if(index == 0){
            if(amount % coins[index]==0){
                dp[index][amount] = amount / coins[index];
                return amount / coins[index] ;
            }else{
                dp[index][amount]= (int)(1e9);
                return (int)(1e9);
            }
            
        }

        if(dp[index][amount] != -1){
            return dp[index][amount];
        }

        int pick = (int)(1e9);
        if(coins[index] <= amount){
            pick = 1 + dpM(coins , amount - coins[index] , index , dp);
        }
        int nonPick = 0 + dpM(coins , amount , index -1  ,dp);

        dp[index][amount] = Math.min(pick , nonPick);

        return dp[index][amount];
    }

    public static int dpT(int[] coins , int amount){
        int n = coins.length ;
        int dp[][] = new int[n][amount + 1];
        
        // base case 
        for(int a = 0 ; a < amount + 1 ; a++){
            if(a % coins[0] == 0){
                dp[0][a] = a / coins[0];
            }else{
                dp[0][a] = (int)(1e9);
            }
        }

        for(int i = 1 ; i< n ; i++){
            for(int a = 0 ; a < amount + 1 ; a++){
                int pick = (int)(1e9);
                if(coins[i] <= a){
                    pick = 1 + dp[i][a - coins[i]];
                }
                int nonPick = dp[i-1][a];
                dp[i][a] = Math.min(pick , nonPick);
            }
        }

        
        if(dp[n-1][amount] == (int)(1e9)){
            return -1;
        }else{
            return dp[n-1][amount] ;
        }

    }

}