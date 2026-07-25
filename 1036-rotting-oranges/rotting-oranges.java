class Pair{
    int i;
    int j;
    int t;
    Pair(int i,int j,int t){
        this.i = i;
        this.j = j;
        this.t = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n  = grid[0].length;
        int tm = 0;
        boolean[][] vis = new boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==2 && !vis[i][j]){
                    q.offer(new Pair(i,j,0));
                    vis[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
          int I= q.peek().i;
          int J =  q.peek().j;
          int T = q.peek().t;
          q.poll();
          tm=Math.max(T,tm);
          int[] neighr = {-1,0,1,0};
          int[] neighc = {0,1,0,-1};
          for(int i=0;i<4;i++){
            int nr = I + neighr[i];
            int nc = J + neighc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n
                && grid[nr][nc]==1 && !vis[nr][nc]){
                    if(grid[nr][nc]==1 && !vis[nr][nc]){
                        q.offer(new Pair(nr,nc,T+1));
                        vis[nr][nc]= true;
                    }
            }
        }  
    } 
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(grid[i][j] == 1 && !vis[i][j]){
                return -1;
            }
        }
    }
    return tm;   
}
}