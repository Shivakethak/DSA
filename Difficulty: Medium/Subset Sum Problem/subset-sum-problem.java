class Solution {
    static Boolean isSubsetSum(int arr[], int sum) {
        int n = arr.length;
        if (n == 0) return sum == 0;
        // boolean[][] dp = new boolean[n][sum+1];
        boolean[] prev = new boolean[sum+1];
        prev[0]=true;
        // for(int i=0;i<n;i++) dp[i][0]=true;
        if(arr[0]<=sum) prev[arr[0]]=true;
        for(int i=1;i<=n-1;i++){
            boolean[] curr = new boolean[sum+1];
            curr[0]=true;
            for(int j=1;j<=sum;j++){
                boolean nottake = prev[j];
                boolean take = false;
                if(j>=arr[i]) take = prev[j-arr[i]];
                curr[j]=take||nottake;
            }
            prev =curr;
        }
        return prev[sum];
    }
}