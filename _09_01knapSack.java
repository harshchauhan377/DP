public class _09_01knapSack{
    public static void main(String[] args){
        int[] weights = {1, 2, 4, 2, 5};
        int[] values = {5, 3, 5, 3, 2};
        int capacity = 10;
        int n = values.length;
        
        System.out.println("rec : "+ rec(capacity , weights , values , n-1));

        int dp[][] = new int[n][capacity+1];
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<capacity + 1 ; j++){
                dp[i][j] = -1;
            }
        }
        System.out.println("dpM : "+ dpM(capacity , weights , values , n-1 , dp));

        System.out.println("dpT : "+ dpT(capacity , weights , values , n-1 ));

        System.out.println("dpO : "+ dpO(capacity , weights , values , n-1 ));



    }

    // rec 
    public static int rec(int c , int w[] , int[]v , int index){
        if(c==0) return 0;

        if(index == 0){
            if(w[index]<=c){
                return v[index];
            }else{
                return 0 ;
            }
        }

        int pick = 0;
        if(w[index] <= c){
            pick = v[index] + rec(c - w[index] , w , v , index - 1);
        }

        int nonPick = 0 + rec(c , w , v , index - 1);

        return Math.max(pick , nonPick);
    }

    public static int dpM(int c , int w[] , int[]v , int index , int dp[][]){
        if(c == 0){
            dp[index][c] = 0;
            return 0 ;
        }

        if(index == 0){
            if(w[index] <= c){
                dp[index][c]=v[index];
                return v[index];
            }else{
                dp[index][c]=0;
                return 0 ;
            }
        }

        if(dp[index][c] != -1){
            return dp[index][c] ;
        }

        int pick = 0;
        if(w[index] <= c){
            pick = v[index] + dpM(c - w[index] , w , v , index - 1 , dp);
        }

        int nonPick = 0 + dpM(c , w , v , index - 1 , dp);

        dp[index][c] = Math.max(pick , nonPick);

        return dp[index][c];
    }

    public static int dpT(int capacity , int w[] , int[]v , int index){
        int dp[][] = new int[index+1][capacity+1];

        for(int i = 0; i < index+1 ; i++){
            dp[i][0] = 0 ;
        }

        for(int c = 0 ; c < capacity ; c++){
            if(w[0]<=c){
                dp[0][c]=v[0];
            }else {
                dp[0][c]=0;
            }
        }

        for(int i = 1; i< index + 1 ; i++){
            for(int j = 0; j< capacity + 1 ; j++){
                int pick = 0 ;
                if(w[i]<j){
                    pick = v[i] + dp[i-1][j - w[i]];
                }
                int nonPick = 0 + dp[i-1][j];
                dp[i][j] = Math.max(pick , nonPick);
            }
        }
        return dp[index][capacity];
    }

        public static int dpO(int capacity , int w[] , int[]v , int index){
        int prev[] = new int[capacity+1];

        // for(int i = 0; i < index+1 ; i++){
            prev[0] = 0 ;
        // }

        for(int c = 0 ; c < capacity ; c++){
            if(w[0]<=c){
                prev[c]=v[0];
            }else {
                prev[c]=0;
            }
        }

        for(int i = 1; i< index + 1 ; i++){
            int curr[] = new int[capacity+1];
            curr[0]=0;
            for(int j = 0; j< capacity + 1 ; j++){
                int pick = 0 ;
                if(w[i]<j){
                    pick = v[i] + prev[j - w[i]];
                }
                int nonPick = 0 + prev[j];
                curr[j] = Math.max(pick , nonPick);
            }
            prev = curr ;
        }
        return prev[capacity];
    }

    

}