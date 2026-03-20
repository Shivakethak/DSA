class Solution {
    public int knapSack(int val[], int wt[], int capacity) {
       int n = val.length;
       int[][] dp = new int[n][capacity+1];
       for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
       return knapSack(n-1,capacity,val,wt,dp);
    }
    public int knapSack(int i,int capacity,int[] val,int[] wt,int[][] dp){
        if(i==0){
            if(capacity>=wt[0]) return (capacity/wt[0])*val[0];
            else return 0;
        }
        if(dp[i][capacity]!=-1) return dp[i][capacity];
        int nottake = knapSack(i-1,capacity,val,wt,dp);
        int take = -(int)1e9;
        if(wt[i]<=capacity) take = val[i]+knapSack(i,capacity-wt[i],val,wt,dp);
        dp[i][capacity] = Math.max(nottake,take);
        return dp[i][capacity];
    }
}