class Solution {
    public boolean wildCard(String txt, String pat) {

        Boolean[][] dp = new Boolean[txt.length()][pat.length()];

        return solve(txt.length() - 1, pat.length() - 1, txt, pat, dp);
    }

    private boolean solve(int i, int j, String s, String p, Boolean[][] dp) {

        // Both exhausted
        if (i < 0 && j < 0)
            return true;

        // Pattern exhausted but string remains
        if (j < 0)
            return false;

        // String exhausted
        if (i < 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        // Already calculated
        if (dp[i][j] != null)
            return dp[i][j];

        // Normal character or '?'
        if (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i)) {
            return dp[i][j] = solve(i - 1, j - 1, s, p, dp);
        }

        // '*'
        if (p.charAt(j) == '*') {
            return dp[i][j] =
                    solve(i, j - 1, s, p, dp) ||
                    solve(i - 1, j, s, p, dp);
        }

        // Characters don't match
        return dp[i][j] = false;
    }
}