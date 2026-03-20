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
        int[][] dp = new int[n][newtarget+1];
        for(int i =0;i<n;i++) Arrays.fill(dp[i],-1);
        return findTargetSumWays(n-1,newtarget,nums,dp);
    }
    public int findTargetSumWays(int i,int target,int[]nums,int[][] dp){
         if(i==0){
            if(target ==0 && nums[0]==0) return 2;
            else if(target==0 || nums[0]==target) return 1;
            else return 0;
         }
         if( dp[i][target]!=-1) return  dp[i][target];
         int nottake = findTargetSumWays(i-1,target,nums,dp);
         int take = 0;
         if(nums[i]<=target) take = findTargetSumWays(i-1,target-nums[i],nums,dp);
         int total = nottake + take ;
         dp[i][target] = total;
         return dp[i][target];
    }
}