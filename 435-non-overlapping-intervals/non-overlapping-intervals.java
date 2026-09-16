class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int n = intervals.length;
        int count = 0;
        int prevend = intervals[0][1];
        for(int i = 1;i<n;i++){
           if(prevend>intervals[i][0]){
           count++;
           }else{
           prevend = intervals[i][1];
           }
        }
        return count;
    }
}