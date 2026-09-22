class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0;i<nums.length;i++){
            xor  ^= nums[i];
        }
        int and = xor & (-xor);
        int first = 0;
        int second = 0;
        for(int i=0;i<nums.length;i++){
            if((and & nums[i])!=0){
                first ^= nums[i];
            }else{
                second ^= nums[i];
            }
        }
        return new int[]{first,second};
    }
}