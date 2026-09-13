class Solution {
    boolean twoSum(int arr[], int target) {
      int n = arr.length;
      Set<Integer> set = new HashSet<>();
      for(int i=0;i<n;i++){
          if(set.contains(target - arr[i])) return true;
          set.add(arr[i]);
      }
      return false;
      
        
    }
}