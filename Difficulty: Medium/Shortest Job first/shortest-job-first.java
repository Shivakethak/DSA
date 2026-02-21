// User function Template for Java

class Solution {
    static int solve(int bt[]) {
        int n = bt.length;
        Arrays.sort(bt);
        double wt =0;
        int[] prefix = new int[n];
        prefix[0]=bt[0];
        for(int i=1;i<n;i++) {
            prefix[i]=prefix[i-1]+bt[i];
        }
        for(int i =0;i<n-1;i++) wt +=prefix[i];
        wt = wt/n;
        return (int) Math.floor(wt);
    }
}
