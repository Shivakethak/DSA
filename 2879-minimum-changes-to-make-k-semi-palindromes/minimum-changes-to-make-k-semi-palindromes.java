import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        
        // 1. Precompute proper divisors for all lengths from 2 to n
        List<Integer>[] divisors = new ArrayList[n + 1];
        for (int len = 2; len <= n; len++) {
            divisors[len] = new ArrayList<>();
            for (int d = 1; d < len; d++) {
                if (len % d == 0) {
                    divisors[len].add(d);
                }
            }
        }

        // 2. Precompute min changes to make substring s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j, divisors[j - i + 1]);
            }
        }

        // 3. DP to partition s[i..n-1] into 'parts' substrings
        // INF set safely below Integer.MAX_VALUE to prevent overflow
        int INF = 1000; 
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[n][0] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int parts = 1; parts <= k; parts++) {
                // Substring must have at least length 2 (end >= i + 1)
                for (int end = i + 1; end < n; end++) {
                    if (dp[end + 1][parts - 1] != INF) {
                        dp[i][parts] = Math.min(
                            dp[i][parts], 
                            cost[i][end] + dp[end + 1][parts - 1]
                        );
                    }
                }
            }
        }

        return dp[0][k];
    }

    private int getSemiPalindromeCost(String s, int start, int end, List<Integer> divs) {
        int len = end - start + 1;
        int minChanges = len;

        for (int d : divs) {
            int changes = 0;
            // Check each of the 'd' modulo groups
            for (int rem = 0; rem < d; rem++) {
                int left = start + rem;
                int right = end - (d - 1 - rem);
                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        changes++;
                    }
                    left += d;
                    right -= d;
                }
            }
            minChanges = Math.min(minChanges, changes);
        }

        return minChanges;
    }
}
