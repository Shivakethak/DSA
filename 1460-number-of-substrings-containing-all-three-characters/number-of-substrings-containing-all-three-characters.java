class Solution {
    public int numberOfSubstrings(String s) {
        int n =s.length();
        Map<Character,Integer> unique = new HashMap<>();
        int l =0;
        int r =0;
        int count =0;
        while(r<n){
            char c = s.charAt(r);
            unique.put(c,unique.getOrDefault(c,0)+1);
            while(unique.size()==3){
                count+=n-r;
                unique.put(s.charAt(l),unique.get(s.charAt(l))-1);
                if(unique.get(s.charAt(l))==0) unique.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return count;
    }
}