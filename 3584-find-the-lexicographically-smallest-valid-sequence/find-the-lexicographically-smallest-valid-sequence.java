class Solution {
    public int[] validSequence(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[] ans = new int[m];

        // last[j] = latest index in word1 from which
        // word2[j...] can be matched exactly.
        int[] last = new int[m];

        for (int i = 0; i < m; i++) {
            last[i] = -1;
        }

        // Build last[] from right to left
        int i = n - 1;
        int j = m - 1;

        while (i >= 0 && j >= 0) {

            if (word1.charAt(i) == word2.charAt(j)) {
                last[j] = i;
                j--;
            }

            i--;
        }

        // We are allowed one mismatch
        boolean canSkip = true;

        j = 0;

        // Greedily choose the smallest indices
        for (i = 0; i < n; i++) {

            if (j == m) {
                break;
            }

            // Normal matching
            if (word1.charAt(i) == word2.charAt(j)) {

                ans[j] = i;
                j++;
            }

            // Use our one allowed mismatch
            else if (canSkip &&
                     (j == m - 1 || i < last[j + 1])) {

                ans[j] = i;
                j++;
                canSkip = false;
            }
        }

        // Couldn't construct the complete sequence
        if (j != m) {
            return new int[0];
        }

        return ans;
    }
}