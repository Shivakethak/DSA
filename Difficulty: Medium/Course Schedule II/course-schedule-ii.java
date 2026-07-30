class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int[] edge : prerequisites){
            int v= edge[0];
            int u = edge[1];
            indegree[v]++;
            adj.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++) if(indegree[i]==0) q.offer(i);
        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int neigh : adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0) q.offer(neigh);
            }
        }
        if(topo.size()!=n) return new ArrayList<>();
        else return topo;
        
    }
}