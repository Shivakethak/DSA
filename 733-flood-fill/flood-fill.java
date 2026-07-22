class Pair{
    int i;
    int j;
    Pair(int i,int j){
     this.i = i;
     this.j = j;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int pcolor = image[sr][sc];
        // dfs(sr,sc,image,vis,pcolor,color);
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        bfs(image,q,vis,pcolor,color);
        return image;
    }
    // public void dfs(int i,int j,int[][] image,  boolean[][] vis,int pcolor,int color){
    //     int n = image.length;
    //     int m = image[0].length;
    //     image[i][j] = color;
    //     vis[i][j] = true;
    //     int[] neighboursrow= {-1,0,1,0};
    //     int[] neighbourscol ={0,-1,0,1};
    //     for(int k =0;k<4;k++){
    //         int I = i+ neighboursrow[k];
    //         int J = j+ neighbourscol[k];
    //         if(I<n && J<m && I>=0 && J>=0) {
    //             if(vis[I][J] !=true && image[I][J]== pcolor) dfs(I,J,image,vis,pcolor,color);
    //     }
    //     }
    // }
    public void bfs(int[][] image,Queue<Pair> q,boolean[][] vis,int pcolor,int color){
      int n = image.length;
      int m = image[0].length;
      while(!q.isEmpty()){
      Pair node = q.poll();
      int first = node.i;
      int second = node.j;
      image[node.i][node.j] = color;
      vis[node.i][node.j] = true;
      int[] neighboursrow= {-1,0,1,0};
      int[] neighbourscol ={0,-1,0,1};
      for(int k =0;k<4;k++){
        int I = first+ neighboursrow[k];
        int J = second+ neighbourscol[k];
          if(I<n && J<m && I>=0 && J>=0) {
                if(vis[I][J] !=true && image[I][J]== pcolor) q.add(new Pair(I,J));
        }
    }
}
    }
}