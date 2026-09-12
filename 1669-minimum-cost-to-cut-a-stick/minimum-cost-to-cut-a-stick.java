class Solution {
    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] arr = new int[m+2];
        arr[0] = 0;
        arr[m+1] = n;
        for(int i = 0; i<m ;i++) arr[i+1] = cuts[i]; 
        Arrays.sort(arr);
        int[][] dp = new int[m+2][m+2];
        for(int i=0;i<m+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return minCost(1,m,arr,dp);
    }
    private int minCost(int i,int j ,int[] cuts,int[][] dp){
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int ind =i;ind<=j;ind++){
         int cost = (cuts[j+1]-cuts[i-1]) + minCost(i,ind-1,cuts,dp) + minCost(ind+1,j,cuts,dp);
         min  = Math.min(cost,min);
        }
        dp[i][j] = min;
        return dp[i][j];
     }
}