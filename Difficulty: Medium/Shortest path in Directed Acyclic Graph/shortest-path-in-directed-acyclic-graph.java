class Pair{
    int v;
    int w;
    Pair(int v,int w){
        this.v = v;
        this.w = w;
    }
}
class Solution {
    public int[] shortestPath(int V, int E, int[][] edges) {
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       int src = 0;
       for(int i =0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] edge : edges){
           int u = edge[0];
           int v = edge[1];
           int w = edge[2];
           adj.get(u).add(new Pair(v,w));
       }
       boolean[] vis = new boolean[V];
       Stack<Integer> s = new Stack<>();
       for(int i=0;i<V;i++){
           if(!vis[i]) dfs(i,vis,s,adj);
       }
       int[] dis = new int[V];
       Arrays.fill(dis,Integer.MAX_VALUE);
       dis[src] =0;
       while(!s.isEmpty()){
           int Node = s.pop();
           int dist = dis[Node];
           if(dist!=Integer.MAX_VALUE){
           for(Pair neigh:adj.get(Node)){
               int nei = neigh.v;
               int nweigh = neigh.w;
               if(dist+nweigh<dis[nei]) dis[nei] = dist+nweigh;
           }
       }else{
           dis[Node]=-1;
       }
       }
       return dis;
    }
    private void dfs(int i,boolean[] vis,Stack<Integer> s ,ArrayList<ArrayList<Pair>> adj){
        vis[i] = true;
        for(Pair node:adj.get(i)){
            int neigh = node.v;
            if(!vis[neigh]){
                dfs(neigh,vis,s,adj);
            }
        }
        s.add(i);
    }
}