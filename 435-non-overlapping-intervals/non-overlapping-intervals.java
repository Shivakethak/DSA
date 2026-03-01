class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)-> a[1]-b[1]);
        int freetime = intervals[0][1];
        int removecount=0;
        for(int i = 1 ;i<n;i++){
        if(intervals[i][0]<freetime){
            removecount+=1;
        }
        else{
            freetime = intervals[i][1];
        }
        }
    return removecount;
}
}