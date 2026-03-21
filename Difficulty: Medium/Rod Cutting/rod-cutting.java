class Solution {
    public int cutRod(int[] price) {
      int n = price.length;
      int[] Price = new int[n+1];
      int[][] dp = new int[n+1][n+1];
      for(int i = 0;i<=n;i++) Arrays.fill(dp[i],-1);
      for(int i =0;i<n;i++){
          Price[i+1]=price[i];
      }
      return cutRod(n,n,Price,dp);
        
    }
    public int cutRod(int i,int rl,int[] Price,int[][] dp){
        if(i==1){
            if(rl>=1) return (rl/i)*Price[1];
            else return 0;
        }
        if(dp[i][rl]!=-1) return dp[i][rl];
        int nottake = cutRod(i-1,rl,Price,dp);
        int take = Integer.MIN_VALUE;
        if(i<=rl) take = Price[i]+cutRod(i,rl-i,Price,dp);
        dp[i][rl] =Math.max(nottake,take);
        return dp[i][rl];
    }
}