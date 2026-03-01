class Solution {
    public int minRemoval(int intervals[][]) {
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)-> a[1]-b[1]);
        int freetime = intervals[0][1];
        int minremoval = 0;
        for(int i =1;i<n;i++){
            if(intervals[i][0]<freetime){
                minremoval+=1;
            }else{
                freetime = intervals[i][1];
            }
        }
        return minremoval;
    }
}
