class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        // Base cases: an empty tree or a 1-node tree has 1 unique structure
        dp[0] = 1;
        dp[1] = 1;
        
        // Compute unique BSTs for each total number of nodes i
        for (int i = 2; i <= n; i++) {
            // Try every node position as the root (j nodes on the left)
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        
        return dp[n];
    }
}
