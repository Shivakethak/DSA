class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int k = n;
        for(int i =0;i<n-1;i++){
            if(nums[i+1]<nums[i]){
               k = i+1;
               break;
            }
        }
        reverse(0,k-1,nums);
        reverse(k,n-1,nums);
        return nums[n-1];
    }
    public int[] reverse(int a,int b ,int[]nums){
        int left= a;
        int right = b;
        while(left<right){
        swap(left,right,nums);
        left++;
        right--;
    }
    return nums;
    }
    public int[] swap(int a,int b,int[] nums){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
        return nums;
    }
}