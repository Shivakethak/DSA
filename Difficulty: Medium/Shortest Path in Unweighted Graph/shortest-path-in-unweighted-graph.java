class Pair{
    int node;
    int dist;
    Pair(int node,int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge :edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] =0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        while(!q.isEmpty()){
            int Node = q.peek().node;
            int Dist = q.peek().dist;
            q.poll();
            for(int neigh : adj.get(Node)){
                if(dist[neigh]>Dist+1){
                    dist[neigh] = Dist+1;
                    q.offer(new Pair(neigh,dist[neigh]));
                    }
            }
        }
        if(dist[dest]!=Integer.MAX_VALUE) return dist[dest];
        else return -1;
        
    }
}