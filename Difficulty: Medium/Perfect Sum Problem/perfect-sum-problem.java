class Solution {
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target+1];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return countSubsets(n - 1, nums, target,dp);
    }

    public int countSubsets(int ind, int[] nums, int target,int[][] dp) {
        if (ind == 0) {
            if (target == 0 && nums[0] == 0) return 2;
            if (target == 0 || nums[0] == target) return 1;
            return 0;
        }
        if(dp[ind][target]!=-1) return dp[ind][target];
        int nottake = countSubsets(ind - 1, nums, target,dp);
        int take = 0;
        if (nums[ind] <= target) {
            take = countSubsets(ind - 1, nums, target - nums[ind],dp);
        }

        dp[ind][target] = take + nottake;
        return dp[ind][target];
    }
}
