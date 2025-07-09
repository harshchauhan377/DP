public class _15_shortestCOmmonSubsequence{
    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab" ;

        int dp[][] = dpT(str1, str2);
        int m = dp.length;
        int n = dp[0].length;

        int i = m - 1; int j = n - 1;

        StringBuilder sb = new StringBuilder();

        while(i>0 && j>0 ){
            if(str1.charAt(i-1)==str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i-- ; j-- ;
            }else if(dp[i-1][j] > dp[i][j-1]){
                sb.append(str1.charAt(i-1));
                i--;
            }else {
                sb.append(str2.charAt(j-1));
                j--;
                
            }
        }

        while(i>0){
            sb.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            sb.append(str2.charAt(j-1));
            j--;
        }
        String ans = sb.reverse().toString();
        System.out.println("dpT : "+ans);
    }

    //Tabulation bottom up approch 
    public static int[][] dpT(String text1, String text2) {
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
        return dp;
    }
}