class Solution {
    public int lcs(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int [][] dp = new int[n1][n2];
        for(int i=0;i<n1;i++){
            Arrays.fill(dp[i],-1);
        }
        return lcs(n1-1,n2-1,s1,s2,dp);
    }
    private int lcs(int i1,int i2,String s1,String s2,int [][] dp){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2)) dp[i1][i2] = 1+lcs(i1-1,i2-1,s1,s2,dp);
        else  dp[i1][i2] = Math.max(lcs(i1-1,i2,s1,s2,dp),lcs(i1,i2-1,s1,s2,dp));
        return dp[i1][i2];
    }
}