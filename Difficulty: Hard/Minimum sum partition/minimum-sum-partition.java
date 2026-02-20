// User function Template for Java

class Solution {
    public int minDifference(int arr[]) {
        int n = arr.length;
        int sum =0;
        for(int i=0;i<n;i++) sum+=arr[i];
        boolean[][] dp = new boolean[n][sum+1];
        for(int i=0;i<n;i++) dp[i][0]=true;
        if(arr[0]<=sum) dp[0][arr[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=1;j<=sum;j++){
                boolean notake = dp[i-1][j];
                boolean take =  false;
                if(arr[i]<=j) take = dp[i-1][j-arr[i]];
                dp[i][j]=take||notake;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<=sum/2;i++){
            if(dp[n-1][i]==true){
                    int s1 = i;
                    int s2 = sum-i;
                    min = Math.min(min,Math.abs(s1-s2));
            }
        }
        return min;
    }
}
    

