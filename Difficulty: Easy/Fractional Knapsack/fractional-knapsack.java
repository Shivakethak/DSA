class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
     int n = val.length;
     int[][] arr  = new int[n][2];
     for(int i=0;i<n;i++) {
         arr[i][0] = val[i];
         arr[i][1] = wt[i];
     }
     Arrays.sort(arr,(a,b)->{
         double r1 = (double) a[0]/a[1];
         double r2 = (double) b[0]/b[1];
         if(r1>r2) return -1;
         if(r1<r2) return 1;
         return 0;
     });
     double value = 0;
     for(int i=0;i<n;i++){
         if(capacity >= arr[i][1]) {
             value+=arr[i][0];
             capacity-=arr[i][1];
         }else{
            value+= (double) arr[i][0] * capacity/arr[i][1];
            break;
         }
     }
     return value;
    }
}