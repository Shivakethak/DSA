class Solution {
    public int findKRotation(int arr[]) {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int ans = Integer.MAX_VALUE;
        int k = 0;
        while(low<=high){
            int mid  = low+(high-low)/2;
            if(arr[mid]<=arr[high]){
                if(arr[mid]<=ans) {
                    ans = arr[mid];
                    k = mid;
                }
                high = mid-1;
            }else{
                if(arr[low]<=ans) {
                    ans = arr[low];
                    k = low;
                }
                low = mid+1;
            }
        }
        return k;
        
    }
}