class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][3];
        for(int i=0;i<=n;i++) Arrays.fill(dp[i],-1);
        return maxProfit(0,1,prices,dp);
    }
    private int maxProfit(int i,int buy,int[] prices,int[][] dp){
        if(i>=prices.length) return 0;
        if(dp[i][buy]!=-1) return dp[i][buy];
        int profit;
        if(buy==1){
            int bought = -prices[i]+ maxProfit(i+1,0,prices,dp);
            int notbought = maxProfit(i+1,1,prices,dp);
            profit = Math.max(bought,notbought);
        }else{
            int sold = prices[i]+maxProfit(i+2,1,prices,dp);
            int notsold = maxProfit(i+1,0,prices,dp);
            profit = Math.max(sold,notsold);
        }
        dp[i][buy] = profit;
        return dp[i][buy];
    }
}