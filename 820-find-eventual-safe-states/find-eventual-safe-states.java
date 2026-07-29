class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int m = graph.length;
        int n = graph[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] vis = new boolean[m];
        boolean[] Pathvis = new boolean[m];
        boolean[] check = new boolean[m];
        for(int i=0;i<m;i++){
            if(!vis[i]) dfs(i,vis,Pathvis,check,graph) ;
        }
        for(int i =0;i<m;i++){
            if(check[i]==false){
                result.add(i);
            }
        }
        return result;
    }
    private boolean dfs(int i, boolean[] vis,boolean[] Pathvis,boolean[] check,int[][] graph){
        vis[i] = true;
        Pathvis[i] = true;
        int[] neighbours = graph[i];
        for(int neigh :neighbours){
            if(!vis[neigh]){
                if(dfs(neigh,vis,Pathvis,check,graph)==true){
                check[i] = true;
                return true;
                 }
            }else if(Pathvis[neigh]==true){
                check[i]  = true;
                return true;
                }
        }
        Pathvis[i] = false;
        return false;
    }
}