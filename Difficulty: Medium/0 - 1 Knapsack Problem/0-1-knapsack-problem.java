class Solution {
    public int knapsack(int W, int val[], int wt[]) {
       int n = val.length;
       int[]prev = new int[W+1];
       for(int i = wt[0];i<=W;i++){
           prev[i] = val[0];
       };
       for(int i = 1;i<n;i++){
        //   int[] curr = new int[W+1];
           for(int j = W;j>=0;j--){
               int nottake = prev[j];
               int take = Integer.MIN_VALUE;
               if(j>=wt[i]) take = val[i]+prev[j-wt[i]];
               prev[j] = Math.max(nottake,take);
           }
        //   prev = curr;
       }
       return prev[W];
    }
}
