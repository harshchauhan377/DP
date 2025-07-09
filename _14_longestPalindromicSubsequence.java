public class _14_longestPalindromicSubsequence{
    public static void main(String[] args) {
        String s = "bbbab" ;
        String sb = new StringBuilder(s).reverse().toString().trim();
        System.out.println("dpT : "+dpT(s,sb));
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