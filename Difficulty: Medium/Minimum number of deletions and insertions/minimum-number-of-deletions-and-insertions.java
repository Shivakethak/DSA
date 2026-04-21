// User function Template for Java

class Solution {
    public int minOperations(String s1, String s2) {
       int n = s1.length();
       int m = s2.length();
       return (n+m)-2*(LCS(s1,s2));
    }
    public int LCS(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length(); 
        int[][] dp = new int[n1+1][n2+1];
        for(int i = 1;i<=n1;i++){
            for(int j =1;j<=n2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }
}