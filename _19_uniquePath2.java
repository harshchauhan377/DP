public class _19_uniquePath2{
    public static void main(String[] args){
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        int m = grid.length;
        int n = grid[0].length;

        System.out.println("dpT : "+dpT(m,n,grid));
    }
    public static int dpT(int m , int n , int[][] grid ){
        int dp[][] = new int[m+1][n+1];

        for(int i = 0; i< m+1 ; i++){
            for(int j = 0; j< n+1  ; j++){
                if(i==0 || j==0 || grid[i-1][j-1]==1){
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