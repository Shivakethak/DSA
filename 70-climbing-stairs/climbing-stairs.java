class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        int pprev = 1;
        int prev = 1;
        for(int i=2;i<=n;i++){
        int curr =pprev+prev;
        pprev = prev;
        prev = curr;
    }
    return prev;
}
}