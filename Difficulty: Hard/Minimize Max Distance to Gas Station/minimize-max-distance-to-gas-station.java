class Solution {
    public double minMaxDist(int[] stations, int K) {
        int n = stations.length;
        if(n<=1) return 0.0;
        int[] arr = new int[n-1];
        for(int i=1;i<=K;i++){
            double max = -1;
            int start = -1;
            for(int j=0;j<n-1;j++){
                double part = (double)(stations[j+1]-stations[j])/(arr[j]+1);
                if(max<part){
                    max = part;
                    start = j;
                }
            }
            arr[start]+=1;
        }
        double MAX = -1;
        for(int i =0;i<n-1;i++){
            double part = (double)(stations[i+1]-stations[i])/(arr[i]+1);
            MAX = Math.max(part,MAX);
        }
        return MAX;
    }
}
