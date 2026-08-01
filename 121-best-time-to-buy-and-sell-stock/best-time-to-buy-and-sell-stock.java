class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        int profit = 0;
        for(int i =1;i<prices.length;i++){
          profit = prices[i]-min;
          max = Math.max(profit,max);
          min = Math.min(prices[i],min);
        }
        if(max<0) return 0;
        else return max;
    }
}