class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n][amount+1];
        for(int i =0;i<n;i++) Arrays.fill(dp[i],-1);
        int ans = coinChange(n-1,amount,coins,dp);
        return (ans==Integer.MAX_VALUE) ? -1:ans;
    }
    public int coinChange(int i,int amount,int[] coins,int[][] dp){
        if(i==0){
            // if(amount==0) return 0;
            if(amount%coins[i]==0) return amount/coins[i];
            else return Integer.MAX_VALUE;
        }
        if(dp[i][amount]!=-1) return dp[i][amount];
        int nottake = coinChange(i-1,amount,coins,dp);
        int take =Integer.MAX_VALUE ;
        if(coins[i]<=amount) {
            int res = coinChange(i,amount-coins[i],coins,dp);
             if ( res!= Integer.MAX_VALUE) {
                take = 1 +  res;
            }
           }
        dp[i][amount] = Math.min(nottake,take);
        return dp[i][amount];
    }
}