class Solution {
    public int uniquePaths(int m, int n) {
       int[][] dp = new int[m][n];
    //    for(int i=0;i<m;i++){
    //     Arrays.fill(dp[i],-1);
    //    }
    //    return uniquePaths(0,0,m,n,dp);
        dp[m-1][n-1] = 1;
        for(int i = m-1; i>=0; i--){
          for(int j = n-1;j>=0;j--){
            if(i== m-1 && j ==n-1) continue;
            int bot = 0;
            int right  = 0;
            if(i+1 < m)  bot  = dp[i+1][j]; 
            if(j+1 <n ) right = dp[i][j+1];
            dp[i][j] = bot  + right ;
          }
       }
       return dp[0][0];
    } 
    // private int uniquePaths(int i,int j,int m ,int n,int[][] dp){
    //     if(i== m-1 &&  j == n-1){
    //         return 1;
    //     }
    //     if(i >=m || j>=n ) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int bottom = uniquePaths(i+1,j,m,n,dp);
    //     int right  = uniquePaths(i,j+1,m,n,dp);
    //     dp[i][j] =  bottom + right;
    //     return dp[i][j];
    // }
}
