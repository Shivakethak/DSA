class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
        }
        int min = 0;
        int low = 1;
        int high = max;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(result(nums,mid)<=threshold){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
    public int result(int[] nums,int div){
        int sum =0;
        for(int j =0;j<nums.length;j++){
            if(nums[j]%div==0){
              sum+=(nums[j]/div);
            }else{
                sum+=(nums[j]/div)+1;
            }
          }
          return sum;
    }
}