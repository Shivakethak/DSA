class Pair{
    int dis;
    int row;
    int col;
    Pair(int dis,int row,int col){
        this.dis = dis;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] != 0 || grid[n - 1][m - 1] != 0) {
            return -1;
        }
        Queue<Pair> pq = new LinkedList<>();
        int[][] distance = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(1,0,0));
        distance[0][0] = 1;
        while(pq.size()>0){
            int dis = pq.peek().dis;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.poll();
            int[] df = {-1,0,1};
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                      int nr = row+df[i];
                      int nc = col+df[j];
                      if(nr<n && nr>=0 && nc<m && nc>=0 && grid[nr][nc]==0){
                        if(distance[nr][nc]>dis+1){
                            distance[nr][nc] = dis+1;
                            if(nr==n-1 && nc==m-1) return distance[nr][nc];
                            pq.add(new Pair(distance[nr][nc],nr,nc));
                        }
                      }
                }
            }
            }
        if(distance[n-1][m-1]!=Integer.MAX_VALUE) return distance[n-1][m-1];
        else return -1;
    }
}