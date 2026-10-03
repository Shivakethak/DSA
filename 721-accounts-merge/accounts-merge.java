class Dsu {
    ArrayList<Integer> parent = new ArrayList<>();
    ArrayList<Integer> rank   = new ArrayList<>();
    Dsu(int v){
        for(int i=0;i<v;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    public int findparent(int u){
        if(parent.get(u)==u){
            return u;
        }
        parent.set(u,findparent(parent.get(u)));
        return parent.get(u);
    }
    public void union(int u,int v){
        int ulpu = findparent(u);
        int ulpv = findparent(v);
        if(ulpu == ulpv) return ;
        if(rank.get(ulpu) < rank.get(ulpv)){
            parent.set(ulpu,ulpv);
        }else if(rank.get(ulpv) < rank.get(ulpu)){
            parent.set(ulpv,ulpu);
        }else{
            parent.set(ulpu,ulpv);
            rank.set(ulpv,rank.get(ulpv)+1);
        }
    }
}
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Dsu dsu = new Dsu(n);
        HashMap<String,Integer> mapofmails = new HashMap<>();
        for(int i=0;i<accounts.size();i++){
            List<String> mails = accounts.get(i);
            for(int j = 1;j<mails.size();j++){
                if(mapofmails.containsKey(mails.get(j))==false){
                    mapofmails.put(mails.get(j),i);
                }else{
                    dsu.union(i,mapofmails.get(mails.get(j)));
                }
            }
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        for(int i =0;i<accounts.size();i++){
            ans.add(new ArrayList<String>());
        }
        for(String key : mapofmails.keySet()){
             int ulp = dsu.findparent(mapofmails.get(key));
             ans.get(ulp).add(key);
        }
        List<List<String>> result = new ArrayList<>();
        for(int i =0;i<ans.size();i++){
            ArrayList<String> eachcomponent = ans.get(i);
            if(eachcomponent.size()==0) continue;
            Collections.sort(eachcomponent);
            List<String> list = new ArrayList<>();
            list.add(accounts.get(i).get(0));
            for(int j=0;j<eachcomponent.size();j++){
                list.add(eachcomponent.get(j));
            }
            result.add(list);
        }
        return result;
    }
}