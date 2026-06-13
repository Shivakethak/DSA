class Solution {
    public int minTime(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            max = Math.max(max,arr[i]);
        }
        int low = max;
        int high = sum;
        int ans =max;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canbepainted(mid,arr,k)==true) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
        }
        }
        return ans;
    }
    private boolean canbepainted(int j,int[]arr,int k){
        int time=0; int  painters = 1;
        for(int i=0;i<arr.length;i++){
            if(time+arr[i]<=j){
                time += arr[i];
            }else{
                painters+=1;
                time = arr[i];
            }
        }
        if(painters<= k) return true;
        else return false;
    }
}
