class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int pcolor = image[sr][sc];
        dfs(sr,sc,image,vis,pcolor,color);
        return image;
    }
    public void dfs(int i,int j,int[][] image,  boolean[][] vis,int pcolor,int color){
        int n = image.length;
        int m = image[0].length;
        image[i][j] = color;
        vis[i][j] = true;
        int[] neighboursrow= {-1,0,1,0};
        int[] neighbourscol ={0,-1,0,1};
        for(int k =0;k<4;k++){
            int I = i+ neighboursrow[k];
            int J = j+ neighbourscol[k];
            if(I<n && J<m && I>=0 && J>=0) {
                if(vis[I][J] !=true && image[I][J]== pcolor) dfs(I,J,image,vis,pcolor,color);
        }
        }
    }
}