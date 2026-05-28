class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m*k>n) return -1;
        int min = Integer.MAX_VALUE;  
        int max = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            max = Math.max(max,bloomDay[i]);
            min = Math.min(min,bloomDay[i]);
        }
        int low = min;
        int high = max;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(bloomDay,mid,m,k)==false){
                low = mid+1 ;
            }else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
    public boolean possible(int[] bloomDay,int day,int m ,int k ){
        int count = 0;
        int bouquets = 0;
        for(int i=0;i<bloomDay.length;i++){
            if(bloomDay[i]<=day){
                count+=1;
            }else{
                 bouquets+=(count/k);
                 count =0;
            }
        }
        bouquets+=(count/k);
        if(bouquets>=m)return true;
        else return false;
    }
}