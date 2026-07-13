class Solution {
    public int findCircleNum(int[][] isConnected) {
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        // for(int i =0;i<n;i++) adj.add(new ArrayList<Integer>());
        // for(int i=0;i<n;i++){
        //     for(int j =0;j<n;j++){
        //          if(i!=j && isConnected[i][j]==1) {
        //             adj.get(i).add(j);
        //     }
        // }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count+=1;
                dfs(i,isConnected,vis);
            }
        }
        return count;    
    }
    private void dfs(int i,int[][] isConnected,boolean[] vis){
        vis[i] = true;
        for(int j = 0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !vis[j]){
                dfs(j,isConnected,vis);
            }
        }
    }
}