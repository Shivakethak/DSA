class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][n];
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
            if(i==j) dp[m-1][i][j] =  grid[m-1][i];
            else dp[m-1][i][j] = grid[m-1][i]+grid[m-1][j];
        }
        }
        for(int i=m-2;i>=0;i--){
            for(int j1= n-1;j1>=0;j1--){
                for(int j2=n-1;j2>=0;j2--){
                    int max = Integer.MIN_VALUE;
                    int[] dj = {-1,0,1};
                      for(int i1=0;i1<3;i1++){
                        for(int j3=0;j3<3;j3++){   
                            if(j1==j2) {
                             if(j1+dj[i1]<n && j2+dj[j3]<n && j1+dj[i1]>=0 && j2+dj[j3]>=0)    max = Math.max(max,grid[i][j1]+dp[i+1][j1+dj[i1]][j2+dj[j3]]);
                            }
                            else  {
                            if(j1+dj[i1]<n && j2+dj[j3]<n && j1+dj[i1]>=0 && j2+dj[j3]>=0) max = Math.max(max,grid[i][j1]+grid[i][j2]+dp[i+1][j1+dj[i1]][j2+dj[j3]]);
                            }
                        }
                      }
                        dp[i][j1][j2] =  max;
                    }  
                }
            }
        return dp[0][0][n-1];
    }
    // public int cherryPickup(int i,int j1,int j2,int[][] grid,int[][][] dp){
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     if(j1<0||j1>=n||j2<0||j2>=n) return (int)-1e8;
    //     if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
    //     if(i==m-1){
    //         if(j1==j2) return grid[i][j1];
    //         else return grid[i][j1]+grid[i][j2];
    //     }
    //     int max = Integer.MIN_VALUE;
    //     int[] dj = {-1,0,1};
    //     for(int i1=0;i1<3;i1++){
    //         for(int j3=0;j3<3;j3++){
    //         if(j1==j2) max = Math.max(max,grid[i][j1]+cherryPickup(i+1,j1+dj[i1],j2+dj[j3],grid,dp));
    //         else  max = Math.max(max,grid[i][j1]+grid[i][j2]+cherryPickup(i+1,j1+dj[i1],j2+dj[j3],grid,dp));
    //     }
    //     }
    //     dp[i][j1][j2] =  max;
    //     return dp[i][j1][j2];
    // }
}