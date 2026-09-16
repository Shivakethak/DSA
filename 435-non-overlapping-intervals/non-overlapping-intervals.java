class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[1],b[1]));
        int n = intervals.length;
        int count = 0;
        int i = 1;
        int prevend = intervals[0][1];
        while(i<n){
        if(prevend>intervals[i][0]){
        count++;
        i++;
        continue;
        } 
        prevend = intervals[i][1];
        i++;
        }
        return count;
    }
}