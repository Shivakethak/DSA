class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(dp[i],-1);
        return minDistance(m-1,n-1,word1,word2,dp);
    }
    public int minDistance(int i,int j,String word1, String word2,int[][] dp){
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(word1.charAt(i)==word2.charAt(j)) dp[i][j]= minDistance(i-1,j-1,word1,word2,dp);
        else {
            dp[i][j] = Math.min(Math.min(1+minDistance(i-1,j,word1,word2,dp),1+minDistance(i,j-1,word1,word2,dp)),1+minDistance(i-1,j-1,word1,word2,dp));
    }
    return dp[i][j];
}
}