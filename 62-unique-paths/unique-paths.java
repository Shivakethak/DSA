class Solution {
    public int uniquePaths(int m, int n) {
        // Total steps required
        int N = m + n - 2;
        // Number of down moves (we choose the smaller one to minimize iterations)
        int k = Math.min(m - 1, n - 1); 
        
        long result = 1;
        
        // Calculate N Choose k: (N * (N-1) * ... * (N-k+1)) / (1 * 2 * ... * k)
        for (int i = 1; i <= k; i++) {
            result = result * (N - k + i) / i;
        }
        
        return (int) result;
    }
}
