class Dsu {
    ArrayList<Integer> rank = new ArrayList<>();
    ArrayList<Integer> parent = new ArrayList<>();
    Dsu(int v){
        for(int i =0;i<v;i++){
            rank.add(1);
            parent.add(i);
        }
    }
    public int findParent(int u){
         if(parent.get(u)==u){
            return u;
         }
         parent.set(u,findParent(parent.get(u)));
         return parent.get(u);
    }
    public void union(int u,int v){
       int pu = findParent(u);
       int pv = findParent(v);
       if(pu==pv) return;
       if(rank.get(pu) < rank.get(pv)){
        parent.set(pu,pv);
       }else if(rank.get(pu) > rank.get(pv)){
        parent.set(pv,pu);
       }else{
        parent.set(pv,pu);
        rank.set(pv,rank.get(pv)+1);
       }
    }
}
class Solution {
    public int makeConnected(int n, int[][] connections) {
        int[] arr = noofComponents(n,connections);
        if( arr[0]>= arr[1]-1) return arr[1]-1;
        return -1;
    }
    private int[] noofComponents(int N,int[][] connections){
        int  n = connections.length; 
        Dsu dsu = new Dsu(N);
        int freenodes = 0;
        for(int k = 0; k<n ;k++){
            int i = connections[k][0];
            int j = connections[k][1];
            if(dsu.findParent(i)!=dsu.findParent(j)){
                    dsu.union(i,j);
            }else{
                    freenodes++;
            }
        }
        int count = 0;
        ArrayList<Integer> parent = dsu.parent;
        for(int i=0;i<parent.size();i++){
            if(parent.get(i)==i){
                count++;
            }
        }
        return new int[]{freenodes,count};
    }
    }
