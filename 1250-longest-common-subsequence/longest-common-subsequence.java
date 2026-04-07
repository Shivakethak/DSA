class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length(); 
        int[][] dp = new int[n2][n1];
        int count = 0;
        for(int i =0;i<n2;i++){
            if(text1.charAt(0)==text2.charAt(i)) count =1;
            dp[i][0] = count; 
        }
         count =0;
         for(int i =0;i<n1;i++){
            if(text1.charAt(i)==text2.charAt(0)) count =1;
            dp[0][i] = count;
        }
        for(int i =1;i<n2;i++){
            for(int j =1;j<n1;j++){
                if(text1.charAt(j)==text2.charAt(i)) dp[i][j]=1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n2-1][n1-1];
    }

    }
