class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public int maxMeetings(int start[], int end[]) {
        int n = start.length;
        int[][] timings = new int[n][2];
        for(int i =0 ;i<n;i++){
            timings[i][0] = start[i];
            timings[i][1] = end[i];
        }
        Arrays.sort(timings,(a,b)->a[1]-b[1]);
        int maxendtime = 0;
        for(int i=0;i<n;i++){
            maxendtime = Math.max(maxendtime,end[i]);
        }
        int[] room = new int[maxendtime+1];
        int count = 0;
        int freetime =0;
        for(int i =0;i<n;i++){
            int starttime = timings[i][0];
            int endtime = timings[i][1];
            if(starttime>=freetime){
                count+=1;
                freetime = endtime+1;
            }

        }
        return count;
    }
}
