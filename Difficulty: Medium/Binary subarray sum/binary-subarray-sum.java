class Solution {
    public int numberOfSubarrays(int[] arr, int target) {
        return Subarrays(arr,target)-Subarrays(arr,target-1);
    }
    private int Subarrays(int[] arr,int target ){
        int n = arr.length;
        int sum = 0;
        int count = 0;
        int l =0;
        int r =0;
        while(r<n){
            sum+=arr[r];
            while(sum>target){
               sum-=arr[l];
               l++;
            }
            count+=(r-l+1);
            r++;
        }
        return count;
    }
}