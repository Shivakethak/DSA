class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prev = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j =0;j<n;j++){
            if(i==j) prev[i][j] =  grid[m-1][i];
            else prev[i][j] = grid[m-1][i]+grid[m-1][j];
        }
        }
        for(int i=m-2;i>=0;i--){
            int[][] curr = new int[n][n];
            for(int j1= n-1;j1>=0;j1--){
                for(int j2=n-1;j2>=0;j2--){
                    int max = Integer.MIN_VALUE;
                    int[] dj = {-1,0,1};
                      for(int i1=0;i1<3;i1++){
                        for(int j3=0;j3<3;j3++){   
                            if(j1==j2) {
                             if(j1+dj[i1]<n && j2+dj[j3]<n && j1+dj[i1]>=0 && j2+dj[j3]>=0)  max = Math.max(max,grid[i][j1]+prev[j1+dj[i1]][j2+dj[j3]]);
                            }
                            else  {
                            if(j1+dj[i1]<n && j2+dj[j3]<n && j1+dj[i1]>=0 && j2+dj[j3]>=0) max = Math.max(max,grid[i][j1]+grid[i][j2]+prev[j1+dj[i1]][j2+dj[j3]]);
                            }
                        }
                      }
                        curr[j1][j2] =  max;
                    }  
                }
                prev = curr;
            }
        return prev[0][n-1];
    }
}