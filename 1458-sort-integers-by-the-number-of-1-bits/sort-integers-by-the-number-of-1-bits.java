class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        int[][] pair = new int[n][2];
        for(int i = 0;i<n;i++){
            pair[i][0] = arr[i];
            pair[i][1] = Count1s(arr[i]);
        }
        Arrays.sort(pair,(x,y)->{
        if(x[1]!=y[1]){
        if(x[1]>y[1]) return 1;
        else return -1;
        }else{
            if(x[0]>y[0]) return 1;
            else return -1;
        }});
        for(int i=0;i<n;i++){
            arr[i] = pair[i][0];
        }
        return arr;
    }
    private int Count1s(int n){
       int count = 0;
       for(int i=0;i<32;i++){
         if((n & (1<<i))!=0){
            count++;
         }
       }
       return count;
    }
}