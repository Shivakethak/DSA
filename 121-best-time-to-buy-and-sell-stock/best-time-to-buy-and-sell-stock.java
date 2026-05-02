class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            int profit = prices[i]-min;
            if(profit<0){
            max = Math.max(max,0);
            }else{
            max = Math.max(max,prices[i]-min);
            }
            min = Math.min(min,prices[i]);
        }
        return max;
    }
}