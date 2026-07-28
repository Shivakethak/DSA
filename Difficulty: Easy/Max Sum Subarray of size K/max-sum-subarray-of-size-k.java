class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        while(r<n){
            sum+=arr[r];
            if(r-l+1==k){
                max = Math.max(max,sum);
                sum-=arr[l];
                l++;
            }
            r++;
        }
        return max;
        
    }
}