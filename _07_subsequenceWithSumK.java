public class _07_subsequenceWithSumK{
    public static void main(String[] args) {
        int arr[]= {10,1,2,7,6,1,5};
        int n = arr.length;
        int k = 8;
        // rec
        System.out.println("rec : "+rec(arr,k,n-1));

        int dp[][] = new int[n][k+1];
        System.out.println("dpM : "+dpM(arr,k,n-1,dp));

        System.out.println("deT : "+dpT(arr,k,n));


    }

    public static boolean rec(int arr[] , int k , int index){
        if(k==0){
            return true ;
        }
        if(index == 0){
            if(k == arr[index]){
                return true ;
            }
            return false;
        }

        boolean pick = false ;
        if(arr[index]<=k){
            pick = rec(arr , k-arr[index] , index - 1);
            if(pick){
                return true;
            }
        }

        boolean nonPick = rec(arr , k , index-1);

        return nonPick;
    }

    // 0 -> null ; 1 -> true  ; 2 -> false  
    public static boolean dpM(int arr[] , int k , int index , int dp[][]){
        if(k==0){
            dp[index][k]=1;
            return true ;
        }
        if(index == 0){
            if(k == arr[index]){
                dp[index][k]=1;
                return true ;
            }
            dp[index][k]=0;
            return false;
        }

        if(dp[index][k]!=0){
            return dp[index][k]==1;
        }

        boolean pick = false ;
        if(arr[index]<=k){
            pick = rec(arr , k-arr[index] , index - 1);
            if(pick){
                dp[index][k]=1;
                return true;
            }
        }

        boolean nonPick = rec(arr , k , index-1);
        dp[index][k] = (nonPick==true)?1:2;

        return nonPick;
    }

    public static boolean dpT(int arr[] , int k , int n){
        int dp[][] = new int[n][k+1];

        for(int i=0 ; i<n ; i++){
            dp[i][0]=1;
        }

        for(int t = 1 ; t<k ; t++){
            if(arr[0]==t){
                dp[0][t]=1;
            }else{
                dp[0][t]=2;
            }
        }

        for(int i = 1 ; i<n ; i++){
            for(int j = 1 ; j<=k ; k++){
                int pick = 2;
                if(arr[i]<=k){
                    pick = dp[i-1][j- arr[i]];
                    if(pick==1){
                        dp[i-1][j] = 1 ;
                        continue;
                    }
                }

                int nonPick = dp[i-1][j];
                dp[i][j] = nonPick ;
            }
            
        }
        return (dp[n-1][k]==1);
    }
    
}