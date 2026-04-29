class Solution {
    public int findFloor(int[] arr, int x) {
       int n = arr.length;
       int ans = -1;
       int low = 0;
       int high =n-1;
       while(low<=high){
           int mid = low+(high-low)/2;
           if(arr[mid]<=x){
               ans = mid;
               low=mid+1;
           }else{
               high=mid-1;
           }
       }
       return  ans;
        
    }
}
