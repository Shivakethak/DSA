// class Solution {
//     public int singleNumber(int[] nums) {
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=0;i<nums.length;i++){
        //     map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        // }
        // for(int key :map.keySet()){
        //     if(map.get(key)<2){
        //        return key;
        //     }
        // }
        // return -1;
    class Solution {
    public int singleNumber(int[] nums) {

        int ans = 0;

        for (int bitIndex = 0; bitIndex < 32; bitIndex++) {

            int cnt = 0;

            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & (1 << bitIndex)) != 0) {
                    cnt++;
                }
            }

            if (cnt % 2 != 0) {
                ans = ans | (1 << bitIndex);
            }
        }

        return ans;
    }
}
