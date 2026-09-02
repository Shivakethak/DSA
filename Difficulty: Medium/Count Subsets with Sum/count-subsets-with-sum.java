class Solution {
    static int perfectSum(int[] arr, int target) {
     int n = arr.length;
     int[][] dp = new int[n][target+1];
     for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
     return perfectSum( n-1,target,arr,dp);
    }
    public static int  perfectSum(int ind ,int target,int[] arr, int[][] dp){
        if(ind==0){
            if(target ==0 && arr[0]==0 ) return 2 ;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int nottake  = perfectSum(ind-1,target,arr,dp);
        int take  =0;
        if(arr[ind]<=target) take = perfectSum(ind-1,target-arr[ind],arr,dp);
        dp[ind][target] = take+nottake;
        return dp[ind][target];
    }
}