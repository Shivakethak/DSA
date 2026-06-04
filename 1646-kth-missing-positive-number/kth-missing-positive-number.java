class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int count = 0;
        int ans = k;
        for(int i=0;i<n;i++){
            if(arr[i]<=ans){
                ans+=1;
            }else{
                return ans;
            }
        }
        return ans;
    }
}