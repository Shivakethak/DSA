class Solution {
    public ArrayList<Integer> maxMeetings(int[] s, int[] f) {
        ArrayList<Integer> schedule = new ArrayList<>();
        int n = s.length;
        int[][]arr = new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0] = s[i];
            arr[i][1] = f[i];
            arr[i][2] = i+1;
        }
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1]){
                return Integer.compare(a[1],b[1]);
            }else{
                return Integer.compare(a[2],b[2]);
            }
        });
        int freetime = -1;
        int count =0;
        for(int i=0;i<n;i++){
            if(arr[i][0]>freetime){
                count++;
                schedule.add(arr[i][2]);
                freetime = arr[i][1];
            }
        }
        Collections.sort(schedule);
        return schedule;
    }
}