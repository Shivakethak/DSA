class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i =0;i<=n;i++) dp[0][i] = 0;
        for(int i=0;i<=m;i++) dp[i][0] =1;
        for(int i=1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(s.charAt(i-1)==t.charAt(j-1)) dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[m][n] ;
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