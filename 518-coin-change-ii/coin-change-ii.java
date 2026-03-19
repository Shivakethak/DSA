class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=1;
            else dp[0][i]=0;
        }
        for(int i =1;i<n;i++){
            for(int j =0;j<=amount;j++){
                int nottake = dp[i-1][j];
                int take = 0;
                if(coins[i]<=j) take = dp[i][j-coins[i]]; 
                dp[i][j] = take + nottake;
            }
        }

        return dp[n-1][amount];
    }
    // public int change(int i,int amount,int[]coins,int[][] dp){
    //     if(i==0){
    //         if(amount%coins[0]==0) return 1;
    //         else return 0;
    //     }
    //     if(dp[i][amount]!=-1) return dp[i][amount];
    //     int nottake = change(i-1,amount,coins,dp);
    //     int take = 0;
    //     if(amount>=coins[i]) take = change(i,amount-coins[i],coins,dp);
    //     return nottake + take;
    // }
}