class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<n;i++){
            if(board[0][i]=='O' && !vis[0][i]){
                dfs(0,i,vis,board);
            }
            if(board[m-1][i]=='O'&& !vis[m-1][i]){
                dfs(m-1,i,vis,board);
            }
        }
        for(int i=0;i<m;i++){
             if(board[i][0]=='O'&& !vis[i][0]){
                dfs(i,0,vis,board);
            }
            if(board[i][n-1]=='O'&& !vis[i][n-1]){
                dfs(i,n-1,vis,board);
            }
        }
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]=='O' && !vis[i][j]){
                    board[i][j]='X';
                }
            }
        }
    }
    private void dfs(int i,int j,boolean[][] vis,char[][] board){
        int m = board.length;
        int n = board[0].length;
        vis[i][j] = true;
        int[] neighr = {-1,0,1,0};
        int[] neighc = {0,1,0,-1};
        for(int k =0;k<4;k++){
           int nr = i+neighr[k];
           int nc = j+neighc[k];
           if(nr<m && nr>=0 && nc<n && nc>=0 && !vis[nr][nc] && board[nr][nc]=='O'){
             dfs(nr,nc,vis,board);
           }
        }
    }
}