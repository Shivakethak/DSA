class Solution {
    public int mySqrt(int x) {
        int low =  0;
        int high = x;
        while(low<=high){
            int mid = low+(high-low)/2;
            long sq =(long) mid*mid;
            long sq1 =(long) (mid+1)*(mid+1);
            if(x-sq>=0 && x-sq1<0){
                return mid;
            }else if(sq>x){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}