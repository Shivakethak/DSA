class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
      ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
      ArrayList<Integer> result = new ArrayList<>();
      int[] indegree = new int[V];
      for(int i =0;i<V;i++){
          adj.add(new ArrayList<>());
      }
      for(int[]edge :edges){
          int v= edge[0];
          int u = edge[1];
          indegree[v]++;
          adj.get(u).add(v);
      }
      Queue<Integer> q = new LinkedList<>();
      for(int i=0;i<V;i++) if(indegree[i]==0) q.add(i);
      while(!q.isEmpty()){
          int node = q.poll();
          result.add(node);
          for(int neigh : adj.get(node)){
              if(indegree[neigh]>0) indegree[neigh]--;
              if(indegree[neigh]==0) q.offer(neigh);
          }
      }
      Collections.sort(result);
      return result;
    }
}