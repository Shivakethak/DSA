class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = isConnected.length;
        int m = isConnected[0].length;
        for(int i =0;i<n;i++) adj.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                 if(i!=j && isConnected[i][j]!=0) {
                    adj.get(i).add(j);
            }
        }
        }
        boolean[] vis = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                count+=1;
                dfs(i,vis,adj);
            }
        }
        return count;    
    }
    private void dfs(int i,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[i] = true;
        for(int n :adj.get(i)){
            if(!vis[n]){
                dfs(n,vis,adj);
            }
        }
    }
}