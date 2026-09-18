
class Solution {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i =0;  int j = 0;
        int max =0;
        int count =0;
        while(i < n && j < n ) {
             if(arr[i] <= dep[j]){
               count+=1;
               max = Math.max(max,count);
               i++;
               }else{
                   count--;
                   j++;
               }
        }
        return max;
    }
}
