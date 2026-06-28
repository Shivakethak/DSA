class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int countred = 0;
        int countwhite = 0;
        int countblue = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==0) countred++;
            else if(nums[i]==1) countwhite++;
            else countblue++;
        }
        int i =0;
        while(countred>0){
            nums[i]=0;
            countred--;
            i++;
        }
        while(countwhite>0){
            nums[i]=1;
            countwhite--;
            i++;
        }
        while(countblue>0){
            nums[i]=2;
            countblue--;
            i++;
        }
    }
}