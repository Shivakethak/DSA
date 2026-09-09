class Solution {
    public int editDistance(String s1, String s2) {
       int n1 = s1.length()-1;
       int n2 = s2.length()-1;
       int[][] dp = new int[n1+1][n2+1];
       for(int i=0;i<=n1;i++) Arrays.fill(dp[i],-1);
       return editDistance(n1,n2,s1,s2,dp);
    }
    private int editDistance(int i,int j, String s1,String s2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return editDistance(i-1,j-1,s1,s2,dp);
        int insert = 1 + editDistance(i,j-1,s1,s2,dp);
        int delete = 1 + editDistance(i-1,j,s1,s2,dp);
        int replace = 1 + editDistance(i-1,j-1,s1,s2,dp);
        dp[i][j] = Math.min(Math.min(insert,delete),replace);
        return dp[i][j];
    }
}