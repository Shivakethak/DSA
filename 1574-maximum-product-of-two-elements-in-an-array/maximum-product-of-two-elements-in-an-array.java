class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int firstmax = nums[0];
        int secondmax = -1;
        for(int i = 1;i<n;i++){
            if(nums[i]>firstmax) {
                secondmax = firstmax;
                firstmax = nums[i];
            }else if(secondmax<nums[i]){
                secondmax = nums[i];
            }
        }
        return (secondmax-1)*(firstmax-1);
    }
}