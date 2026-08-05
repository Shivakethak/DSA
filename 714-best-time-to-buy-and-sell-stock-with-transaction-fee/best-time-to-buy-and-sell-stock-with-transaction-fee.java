class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] ahead = new int[2];
        int[] curr = new int[2];

        for (int i = prices.length - 1; i >= 0; i--) {

            // buy state
            curr[1] = Math.max(
                    -prices[i] + ahead[0],
                    ahead[1]
            );

            // sell state
            curr[0] = Math.max(
                    prices[i] - fee + ahead[1],
                    ahead[0]
            );

            ahead = curr.clone();
        }

        return ahead[1];
    }
}