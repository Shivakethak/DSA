class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int[] prefixsum = new int[n];
        int[] backprefixsum = new int[n];
        prefixsum[0] = cardPoints[0];
        backprefixsum[n-1] = cardPoints[n-1];
        for(int i=1;i<n;i++) prefixsum[i] = prefixsum[i-1]+cardPoints[i];
        for(int i=n-2;i>=0;i--) backprefixsum[i] = backprefixsum[i+1]+cardPoints[i];
        int max = Math.max(prefixsum[k-1],backprefixsum[n-k]);
        int j = n-1;
        for(int i =k-2;i>=0;i--){
         int sum = prefixsum[i]+backprefixsum[j];
         max = Math.max(max,sum);
         j--;
        }
        return max;
    }
}