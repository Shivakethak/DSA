class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int  n = weights.length;
        int max = Integer.MIN_VALUE;
        int sum1 =0;
        for(int i=0;i<n;i++){
          max = Math.max(max,weights[i]);
          sum1+=weights[i];
        }
        int low = max;
        int high = sum1;
        int ans = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(possible(weights,mid,days)==true){
                ans = mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public boolean possible(int[]weights,int capacity,int days){
         int sum =0;int day =1;
            for(int i=0;i<weights.length;i++){
                sum+=weights[i];
                if(sum>capacity){
                    day+=1;
                    sum=weights[i];
                }
            }
            if(day<=days) return true;
            return false;
        }
    }
