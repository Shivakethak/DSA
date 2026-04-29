class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        vector<int> result;
        // int s = lowerBound(nums,target);
        // int e = upperBound(nums,target);
        int s = -1;
        int e = -1;
        for(int i=0;i<n;i++){
            if(nums[i]==target){
            if(s==-1) s = i;
            else e = i;  
        }
        }
        if(s==-1) return {-1,-1};
        if(e==-1) return {s,s};
        result.push_back(s);
        result.push_back(e);
        return result;
    }
    // int lowerBound(vector<int>& nums,int target){
    //     int n = nums.size();
    //     int low =0;
    //     int high = n-1;
    //     int ans = -1;
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(nums[mid]==target){
    //             ans = mid;
    //             high = mid-1;
    //         }else if(nums[mid]>target){
    //             high = mid-1;
    //         }else{
    //             low = mid+1; 
    //         }
    //     }
    //     return ans;
    // }
    // int upperBound(vector<int>&nums,int target){
    //     int n = nums.size();
    //     int low= 0;
    //     int high = n-1;
    //     int ans = -1;
    //     while(low<=high){
    //         int mid = low+(high-low)/2;
    //         if(nums[mid]==target){
    //             ans = mid;
    //             low = mid+1;
    //         }else if(nums[mid]>target){
    //             high = mid-1;
    //         }else{
    //             low = mid+1;
    //         }
    //     }
    //     return ans;
    // }
};