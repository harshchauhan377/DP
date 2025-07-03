public class _06_houseRobber2{
    public static void main(String[] args){
        int[] nums = {1,2,3,1};
        // int this all houses are in circle so first and last house are not safe for robber
        System.out.println("Maximum amount of money that can be robbed is: "+rob(nums));
    }

    public static int rob(int arr[]){
        int n = arr.length;
        if(n==1) return arr[0];

        int arr1[] = new int[n-1];
        int arr2[] = new int[n-1];
        int j = 0; int k = 0;

        for(int i =0; i<n ; i++){
            if(i!=0){
                arr1[j++] = arr[i];
            }
            if(i!=n-1){
                arr2[k++] = arr[i];
            }
        }

        return Math.max(rob1(arr1), rob1(arr2));
    }
    
    public static int rob1(int arr[]){
        int n = arr.length;
        if(n==1){
            return arr[0];
        }

        int prev2 = 0 ;
        int prev1 = arr[0];
        int ans = 0 ;
        for(int i = 2 ; i<=n ; i++){
            int pick = arr[i-1] + prev2;
            int nonPick = 0 + prev1;
            ans = Math.max(pick , nonPick);
            prev2 = prev1 ;
            prev1 = ans ;
        }
        return ans ;
    }
}