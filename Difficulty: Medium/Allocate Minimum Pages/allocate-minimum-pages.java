class Solution {
    public int findPages(int[] arr, int k) {
     int n = arr.length;
     if(k>n) return -1;
     int max = Integer.MIN_VALUE;
     int sum =0;
     for(int i=0;i<n;i++){
         max = Math.max(max,arr[i]);
         sum+=arr[i];
     }
     int low =max;
     int high = sum;
     int ans = 0;
     while(low<=high){
        int mid = low+(high-low)/2;
        if(canbeAllocated(mid,arr,k)==true){
            ans = mid;
            high = mid-1;
         }else{
             low = mid+1;
         }
     }
     return ans;
    }
    public boolean canbeAllocated(int j,int[] arr,int k){
        int count = 1;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            if(sum+arr[i]<=j){
                sum+=arr[i];
            }else{
                count++;
                sum = arr[i];
            }
           
        }
        if(count<=k) return true;
        else return false;
    }
}