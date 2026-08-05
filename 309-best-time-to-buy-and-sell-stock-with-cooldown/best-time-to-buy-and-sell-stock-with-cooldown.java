class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] after1 = new int[2];
        int[] after2 = new int[2];
        for(int i=0;i<2;i++) after2[i] = 0;
        for(int i=0;i<2;i++) after1[i] = 0;
        for(int i=n-1;i>=0;i--){
            int[] curr = new int[2];
            for(int j=0;j<=1;j++){
                int profit;
                if(j==1){
                    int bought = -prices[i]+ after2[0];
                    int notbought =after2[1];
                    profit = Math.max(bought,notbought);
                }else{
                    int sold = prices[i]+after1[1];
                    int notsold = after2[0];
                    profit = Math.max(sold,notsold);
                }
                curr[j] = profit;
            }
            after1 = after2;
            after2 = curr;
        }
        return after2[1];
    }
}