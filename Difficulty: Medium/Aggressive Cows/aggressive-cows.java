class Solution {
    public int aggressiveCows(int[] stalls, int k) {
       int n = stalls.length;
       Arrays.sort(stalls);
       int min = stalls[0];
       int max = stalls[n-1];
       for(int i=1;i<=max-min;i++){
           if(canbeplaced(i,stalls,k)==true) continue;
           else return i-1;
       }
       return max-min;
    }
    public boolean canbeplaced(int j,int[]stalls,int k){
        int last =stalls[0];
        int count = 1;
        for(int i =0;i<stalls.length;i++){
            if(stalls[i]-last>=j){
                count+=1;
                last = stalls[i];
            }
            if(count==k) return true;
        }
        return false;
    }
}