public class _08_perfectSumproblem{
    public static void main(String[] args) {
        int arr[]= {2, 5, 1, 4, 3};
        int target = 10 ;
        int n = arr.length;
        System.out.println("....Count of subset equal to taegt (rec) : "+ rec(arr , target , n-1));

        int dp[][] = new int[n][target+1];
        for(int i =0; i<n ; i++){
            for(int j = 0; j< target + 1 ; j ++){
                dp[i][j]=-1;
            }
        }
        System.out.println("....Count of subset equal to taegt (dpM) : "+ dpM(arr, target , n-1 , dp));

        System.out.println("....Count of subset equal to taegt (dpT) : "+ dpT(arr, target , n-1));

        System.out.println("....Count of subset equal to taegt (dpT) : "+ dpO(arr, target , n-1));


    }

    // recursion 
    public static int rec(int arr[] , int t , int index){
        if(index==0){  // jab bhi index 0 hoga check karenge 
            if(t==0 && arr[index]==0) return 2; // if there is no zero in array we will remove this and next 
            else if(t==0) return 1; // ..
            else if(t==arr[index]) return 1;
            else return 0;
        }
        int pick = 0 ;
        if(arr[index]<=t){
            pick = rec(arr , t - arr[index] , index-1);
        }
        int nonPick = rec(arr , t , index -1);

        return pick + nonPick;

    }

    public static int dpM(int arr[] , int t , int index, int dp[][]){
        if(index==0){
            if(t==0 && arr[index]==0){
                dp[index][t]=2;
                return 2;
            }else if(t==0){
                dp[index][t]=1;
                return 1;
            }else if(t==arr[index]){
                dp[index][t]=1;
                return 1;
            }else{
                dp[index][t]=0;
                return 0;
            }
        }

        if(dp[index][t]!= -1){
            return dp[index][t];
        }

        int pick = 0;
        if(arr[index]<=t){
            pick = dpM(arr , t - arr[index] , index - 1 , dp);
        }

        int nonPick = dpM(arr , t  , index - 1 , dp);

        dp[index][t] = pick + nonPick ;
        return dp[index][t];
    }

    public static int dpT(int arr[] , int target , int index){
        int dp[][] = new int[index+1][target+1];

        for(int t = 0 ; t<target + 1 ; t++){
            if(t==0 && arr[0]==0){
                dp[0][t]=2;   
            }else if(t==0){
                dp[0][t]=1;
            }else if(t==arr[0]){
                dp[0][t]=1;
            }else{
                dp[0][t]=0;
            }
        }

        for(int i = 1 ; i<=index ; i++){
            for(int j = 0 ; j<target+1 ; j++){
                int pick = 0 ;
                if(arr[i]<=j){
                    pick = dp[i-1][j-arr[i]];
                }
                int nonPick = dp[i-1][j];
                dp[i][j] = pick + nonPick ;
            }
        }
        return dp[index][target];

    }

    public static int dpO(int arr[] , int target , int index){
        int prev[] = new int[target+1];

        for(int t = 0 ; t<target + 1 ; t++){
            if(t==0 && arr[0]==0){
                prev[t]=2;   
            }else if(t==0){
                prev[t]=1;
            }else if(t==arr[0]){
                prev[t]=1;
            }else{
                prev[t]=0;
            }
        }

        for(int i = 1 ; i<=index ; i++){
            int curr[] = new int[target + 1];
            for(int j = 0 ; j<target+1 ; j++){
                int pick = 0 ;
                if(arr[i]<=j){
                    pick = prev[j-arr[i]];
                }
                int nonPick = prev[j];
                curr[j] = pick + nonPick ;
            }
            prev = curr ;
        }
        return prev[target];

    }

    
}