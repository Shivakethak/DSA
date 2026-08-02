class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int l =0;
        int r = 0;
        int max =0;
        while(r<n){
            while(map.containsKey(s.charAt(r))){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
                l++;
            }
            map.put(s.charAt(r),1);
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}