class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        combinationSum(0,target,candidates,temp,result);
        return result;
    }
    public void combinationSum(int i,int target,int[] candidates,List<Integer> temp,List<List<Integer>> res){
        if(i==candidates.length) return;
        if(target==0){
         res.add(new ArrayList<>(temp));
         return;
        }
        if(candidates[i]<=target) {
            temp.add(candidates[i]);
            combinationSum(i,target-candidates[i],candidates,temp,res);
            temp.remove(temp.size()-1);
        }
        combinationSum(i+1,target,candidates,temp,res);
}
}
