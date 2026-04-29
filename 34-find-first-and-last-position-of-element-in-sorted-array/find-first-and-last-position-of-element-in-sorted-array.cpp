class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int n = nums.size();
        int s = lowerBound(nums,target);
        int e = upperBound(nums,target);
        if(s==n||(nums[s]!=target)) return {-1,-1};
        // if(e==n) return {s,s};
        return {s,e-1};
    }
    int lowerBound(vector<int>& nums,int target){
        int n = nums.size();
        int low =0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>=target){
                ans = mid;
                high = mid-1;
            }else{
                low= mid+1;
            }
        }
        return ans;
    }
    int upperBound(vector<int>&nums,int target){
        int n = nums.size();
        int low= 0;
        int high = n-1;
        int ans = n;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]>target){
                ans = mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
};
