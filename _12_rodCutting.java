public class _12_rodCutting{
    public static void main(String[] args) {
        int prices [] = {3, 5, 8, 9, 10, 17, 17, 20};
        int N = prices.length;

        System.out.println("rec : "+ rec(N , N-1 , prices));

        int dp[][] = new int[N][N+1];
        for(int i = 0 ; i<N ; i++){
            for(int j = 0 ; j<N+1 ; j++){
                dp[i][j] = -1;
            }
        }

        System.out.println("dpM : "+ dpM(N , N-1 , prices , dp));

        System.out.println("dpT : "+ dpT(prices));
    }

    public static int rec(int N , int index , int prices[]){
        if(index==0){
            return N * prices[0];
        }

        int pick = 0 ;
        int currL = index + 1;
        if(N>=currL){
            pick = prices[index] + rec(N - currL , index , prices);
        }

        int nonPick = 0 + rec(N, index - 1, prices);

        return Math.max(pick , nonPick);
    
    }

    public static int dpM(int N , int index , int prices[] , int dp[][]){
        if(index == 0){
            dp[index][N] = N * prices[0];
            return N * prices[0];
        }

        if(dp[index][N] != -1){
            return dp[index][N];
        }

        int pick = 0 ;
        int currL = index + 1 ;
        if(currL <= N){
            pick = prices[index] + dpM(N - currL , index , prices , dp);
        }

        int nonPick = 0 + dpM(N , index - 1 , prices , dp);

        dp[index][N] = Math.max(pick , nonPick);

        return dp[index][N];
    }

    public static int dpT(int[] price) {
        // code here
        int N = price.length;
        int dp[][] = new int[N][N+1];
        
        for(int l = 0 ; l < N + 1 ; l++){
            dp[0][l] = l * price[0];
        }
        
        for(int i = 1; i < N ; i++){
            for(int j = 0 ; j < N + 1 ; j++){
                int pick = 0 ;
                int currL = i + 1 ;
                if(currL <= j){
                    pick = price[i] + dp[i][ j - currL ] ;
                }
                int nonPick = 0 + dp[i - 1][j];
                
                dp[i][j] = Math.max(pick , nonPick);
            }
        }
        return dp[N-1][N];
        
    }

}