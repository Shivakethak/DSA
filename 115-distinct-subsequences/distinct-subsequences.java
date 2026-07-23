class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++) Arrays.fill(dp[i],-1);
        return numDistint(m-1,n-1,s,t,dp);
    }
    private int numDistint(int i,int j,String s1,String s2,int[][] dp ){
        if(j<0) return 1;
        if(i<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) dp[i][j] = numDistint(i-1,j-1,s1,s2,dp)+numDistint(i-1,j,s1,s2,dp);
        else dp[i][j] = numDistint(i-1,j,s1,s2,dp);
        return dp[i][j];
    }
}