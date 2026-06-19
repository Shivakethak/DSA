class Solution {
    public String longestCommonPrefix(String[] strs) {
        // String S = strs[0];
        // for(int i=1;i<strs.length;i++){
        //     String S1 = strs[i];
        //     String s = "";
        //     int j =0;
        //     while(j<S.length() && j<S1.length()){
        //         if(S1.charAt(j)==S.charAt(j)){
        //             char c = S1.charAt(j);
        //             s=s+c;
        //             j++;
        //         }else{
        //             break;
        //         }
        //     }
        //     S=s;
        // }
        // return S;
        String s = strs[0];
        String s1 = "";
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            for(int j =1;j<strs.length;j++){
                String S = strs[j];
                if(i>=S.length() || S.charAt(i)!=c){
                    return s1;
            }
            }
            s1 = s1+c;
        }
        return s1;
    }
}