class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) prev[i]=1;
            else prev[i]=0;
        }
        for(int i =1;i<n;i++){
            int[] curr = new int[amount+1];
            for(int j =0;j<=amount;j++){
                int nottake = prev[j];
                int take = 0;
                if(coins[i]<=j) take = curr[j-coins[i]]; 
                curr[j] = take + nottake;
            }
            prev = curr;
        }

        return prev[amount];
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