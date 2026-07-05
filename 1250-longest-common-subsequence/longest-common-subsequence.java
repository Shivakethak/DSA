class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) Arrays.fill(dp[i],-1);
        return LCS(n-1,m-1,text1,text2,dp);
    }
    public int LCS(int i1,int i2,String text1,String text2,int[][] dp){
        if(i1<0 ||i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(text1.charAt(i1)==text2.charAt(i2)) dp[i1][i2] =  1+LCS(i1-1,i2-1,text1,text2,dp);
        else dp[i1][i2] = Math.max(LCS(i1-1,i2,text1,text2,dp),LCS(i1,i2-1,text1,text2,dp));
        return dp[i1][i2];
    }
}