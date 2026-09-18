class Pair{
    int start;
    int end ;
    Pair(int start,int end){
        this.start = start;
        this.end = end;
    }
}
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        ArrayList<Pair> res  = new ArrayList<>();
        int i =0;
        // no overlap
        while(i<n && intervals[i][1] < newInterval[0]){
        res.add(new Pair(intervals[i][0],intervals[i][1]));
        i++;
        }
        // merging overlaping intervals
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        // add the merged result to the ans
        res.add(new Pair(newInterval[0],newInterval[1]));
        while(i<n){
            res.add(new Pair(intervals[i][0],intervals[i][1]));
            i++;
        }
        int N = res.size();
        int[][] result = new int[N][2];
        for(int k = 0;k<N;k++){
            result[k][0] = res.get(k).start;
            result[k][1] = res.get(k).end;
        }
        return result;

                }
}
