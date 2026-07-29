class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      ArrayList<Integer> result = new ArrayList<>();
      for(int i =0;i<V;i++){
          adj.add(new ArrayList<>());
      }
      for(int[]edge :edges){
          int u= edge[0];
          int v = edge[1];
          adj.get(u).add(v);
      }
      boolean[] vis = new boolean[V];
      Stack<Integer> s = new Stack<>();
      for(int i =0;i<V;i++){
          if(!vis[i]) dfs(i,vis,s,adj);
      }
      while(!s.isEmpty()){
          int vertex = s.pop();
          result.add(vertex);
      }
      return result;
    }
    private void dfs(int i,boolean[] vis,Stack<Integer> s,ArrayList<ArrayList<Integer>> adj){
        vis[i]=true;
        for(int neigh : adj.get(i)){
            if(!vis[neigh]){
                dfs(neigh,vis,s,adj);
            }
        }
        s.add(i);
    }
}