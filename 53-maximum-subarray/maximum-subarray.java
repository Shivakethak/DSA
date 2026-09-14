class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;
        int maxsum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            if(sum>maxsum) maxsum = Math.max(sum,maxsum);
            if(sum<0) sum =0;
        }
        return maxsum;
}
}