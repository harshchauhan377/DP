public class _13_longestCommonSubsequence{
    public static void main(String[] args){
        String text1 = "abcde"; 
        String text2 = "ace" ;
        int m = text1.length();
        int n = text2.length();
        
        System.out.println("rec : "+ rec( m-1 , n-1 , text1 , text2 ));

        int dp[][] = new int[m+1][n+1];
        for(int i =0 ; i<m+1 ; i++){
            for(int j =0; j< n+1 ; j++){
                dp[i][j] = -1;
            }
        }
        
        System.out.println("dpM : "+ dpM( m, n , text1 , text2 , dp));

        System.out.println("dpT : "+ dpT(text1 , text2));
    }

    // recusion 
    public static int rec(int i , int j , String text1 , String text2){
        if(i<0 || j<0){    // agr dono me se koi bhi khatam ho jaye tho  
            return 0 ;
        }

        if(text1.charAt(i) == text2.charAt(j)){
            return 1 + rec(i-1 , j-1 , text1 , text2);
        }else{
            int case1 = rec(i-1 , j , text1 , text2);
            int case2 = rec(i , j-1 , text1 , text2);
            return Math.max(case1 , case2);
        }
    }

    //memoization top down approch 
    public static int dpM(int i , int j , String text1 , String text2 , int dp[][]){
        if(i == 0 || j == 0){
            dp[i][j] = 0 ;
            return 0 ;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(text1.charAt(i-1) == text2.charAt(j-1)){
            dp[i][j] = 1 + dpM(i - 1 , j - 1, text1 , text2 , dp);
            return dp[i][j];
        }else{
            int case1 = dpM(i-1 , j , text1 , text2 , dp);
            int case2 = dpM(i , j-1 , text1 , text2 , dp);
            dp[i][j] = Math.max(case1 , case2);
            return dp[i][j];
        }
    }

    //Tabulation bottom up approch 
    public static int dpT(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int dp[][] = new int[m+1][n+1];

        dp[0][0] = 0 ;

        for(int i = 1 ; i<m+1 ; i++){
            for(int j = 1 ; j< n+1 ; j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    int case1 = dp[i-1][j];
                    int case2 = dp[i][j-1];
                    dp[i][j] = Math.max(case1,case2);
                    
                }
            }
        }
        return dp[m][n];
    }


}