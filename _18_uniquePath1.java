public class _18_uniquePath1{
    public static void main(String[] args) {
       int m = 3 ; int n = 7; 

       System.out.println("rec : "+rec(m-1,n-1));

       int dp[][] = new int[m+1][n+1];
       for(int i = 0; i< m +1 ; i++){
        for(int j = 0; j< n +1 ; j++){
            dp[i][j] = -1;
        }
       }

       System.out.println("dpM : "+dpM(m,n,dp));

       System.out.println("dpT : "+dpT(m,n));
    }

    public static int rec(int m , int n){
        if(m==0 && n== 0){
            return 1 ;
        }

        if(m<0 || n<0){
            return 0 ;
        }

        int ways = rec(m-1 , n) + rec(m , n-1);
        return ways;
    }
    
    //dpM memeoization
    public static int dpM(int m , int n , int dp[][]){
        if(m==1 && n== 1){
            dp[m][n] = 1;
            return 1 ;
        }

        if(m==0 || n==0){
            dp[m][n] = 0 ;
            return 0 ;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        dp[m][n]  = dpM(m-1 , n , dp) + dpM(m , n-1 , dp);
        
        return dp[m][n] ;
    }

    public static int dpT(int m , int n ){
        int dp[][] = new int[m+1][n+1];

        for(int i = 0; i< m+1 ; i++){
            for(int j = 0; j< n+1  ; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0 ;
                }else if(i == 1 && j == 1){
                    dp[i][j] = 1 ;
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[m][n];
    }
}