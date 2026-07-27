class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        HashMap<Integer,Integer> unique = new HashMap<>();
        int l = 0;
        int r = 0;
        int len = 0;
        while(r<n){
            unique.put(fruits[r],unique.getOrDefault(fruits[r],0)+1);
            while(unique.size()>2){
                unique.put(fruits[l],unique.get(fruits[l])-1);
                if(unique.get(fruits[l])==0) unique.remove(fruits[l]);
                l++;
            }
            len = Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}