class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(n<k) return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            sum +=nums[i];
        }
        int low = max;
        int high = sum;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canbesplitted(mid,nums,k)==true) {
            ans = mid;
            high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public boolean canbesplitted(int j,int[] nums,int k){
     int sum =0;int partitions =1;
     for(int i =0;i<nums.length;i++){
        if(sum+nums[i]<=j){
            sum+=nums[i];
        }else{
            partitions+=1;
            sum=nums[i];
        }
     }
     if(partitions<=k)return true;
     else return false; 
    }
}