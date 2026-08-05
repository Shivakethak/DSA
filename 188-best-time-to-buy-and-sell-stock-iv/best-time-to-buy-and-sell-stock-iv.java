class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][3][k+1];
        for(int i=0;i<n+1;i++){
            for(int j =0;j<3;j++){
            Arrays.fill(dp[i][j],-1);
        }
        }
        return maxProfit(0,1,k,prices,dp);
    }
    private int maxProfit(int i,int buy,int k,int[] prices,        int[][][] dp ){
        if(i==prices.length) return 0;
        if(k==0) return 0;
        if(dp[i][buy][k]!=-1) return dp[i][buy][k];
        int profit;
        if(buy==1){
            int bought = -prices[i]+maxProfit(i+1,0,k,prices,dp);
            int notbought = maxProfit(i+1,1,k,prices,dp);
            profit = Math.max(bought,notbought);
        }else{
            int bought = prices[i]+maxProfit(i+1,1,k-1,prices,dp);
            int notbought = maxProfit(i+1,0,k,prices,dp);
            profit = Math.max(bought,notbought);
        }
        dp[i][buy][k] = profit;
        return dp[i][buy][k];
    }
}