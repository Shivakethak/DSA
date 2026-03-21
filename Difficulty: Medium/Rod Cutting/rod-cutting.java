class Solution {
    public int cutRod(int[] price) {
      int n = price.length;
    //   int[] Price = new int[n+1];
      int[][] dp = new int[n][n+1];
      for(int i = 0;i<n;i++) Arrays.fill(dp[i],-1);
    //   for(int i =0;i<n;i++){
    //       Price[i+1]=price[i];
    //   }
      return cutRod(n-1,n,price,dp);
        
    }
    public int cutRod(int i,int rl,int[] price,int[][] dp){
        if(i==0){
            if(rl>=1) return rl*price[0];
            else return 0;
        }
        if(dp[i][rl]!=-1) return dp[i][rl];
        int nottake = cutRod(i-1,rl,price,dp);
        int take = Integer.MIN_VALUE;
        if((i+1)<=rl) take = price[i]+cutRod(i,rl-(i+1),price,dp);
        dp[i][rl] =Math.max(nottake,take);
        return dp[i][rl];
    }
}