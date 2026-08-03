class Solution {
    public int longestKSubstr(String s, int k) {
       int n = s.length();
       HashMap<Character,Integer> map = new HashMap<>();
       int l =0;
       int r =0;
       int max =-1;
       while(r<n){
           char c = s.charAt(r);
           map.put(c,map.getOrDefault((c),0)+1);
           while(map.size()>k){
               map.put(s.charAt(l),map.get(s.charAt(l))-1);
               if(map.get(s.charAt(l))==0) map.remove(s.charAt(l));
               l++;
           }
           if(map.size()==k) max = Math.max(r-l+1,max);
           r++;
       }
       return max;
        
    }
}