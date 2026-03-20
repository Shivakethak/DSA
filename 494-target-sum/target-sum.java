class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i =0;i<n;i++){
         sum+=nums[i];
        }
        if(sum<target) return 0;
        if((sum-target)%2!=0) return 0;
        int newtarget = (sum-target)/2;
        return findTargetSumWays(n-1,newtarget,nums);
    }
    public int findTargetSumWays(int i,int target,int[]nums){
         if(i==0){
            if(target ==0 && nums[0]==0) return 2;
            else if(target==0 || nums[0]==target) return 1;
            else return 0;
         }
         int nottake = findTargetSumWays(i-1,target,nums);
         int take = 0;
         if(nums[i]<=target) take = findTargetSumWays(i-1,target-nums[i],nums);
         int total = nottake + take ;
         return total;
    }
}