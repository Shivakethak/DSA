class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int prev[] = new int[amount+1];
        for(int i =0;i<=amount;i++){
           if(i%coins[0]==0) prev[i]= i/coins[0];
           else prev[i] = Integer.MAX_VALUE;
        }
        for(int i =1;i<n;i++){
            int[] curr = new int[amount+1];
            for(int j =0;j<=amount;j++){
                int nottake = prev[j];
                int take = Integer.MAX_VALUE;
                if(coins[i]<=j) {
                    int res = curr[j-coins[i]];
                    if(res!=Integer.MAX_VALUE){
                        take = 1+res;
                    }
                }
                curr[j] = Math.min(nottake,take);
            }
            prev = curr;
        }
        int ans = prev[amount];
        return (ans==Integer.MAX_VALUE) ? -1:ans;
    }
}
