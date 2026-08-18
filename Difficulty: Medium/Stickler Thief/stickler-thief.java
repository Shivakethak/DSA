class Solution {
    public int findMaxSum(int arr[]) {
         int n = arr.length;
         int[] dp = new int[n+1];
         Arrays.fill(dp,-1);
         return findMaxSum(0,arr,dp);
    }
    public int findMaxSum(int i,int[] arr,int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int takesum = findMaxSum(i+2,arr,dp) +arr[i];
        int nottakesum = findMaxSum(i+1,arr,dp);
        dp[i] = Math.max(takesum,nottakesum);
        return dp[i];
    }
}