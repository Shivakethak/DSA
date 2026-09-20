class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> S = new Stack<>();
        Stack<Integer> S1 = new Stack<>();
        for(int i=0 ; i<n ; i++){
            if(s.charAt(i)=='('){
                S.push(i);
            }else if (s.charAt(i)==')'){
                if(S.size()==0 && S1.size() == 0){
                    return false;
                }
                if(S.size() ==0 && S1.size()!=0){
                        S1.pop();
                        continue;
                    }
                if(S.size()!=0){
                    S.pop();
                }
            }else{
                S1.push(i);
            }
        }
        if(S.size()==0) return true;
        while(!S.isEmpty() && !S1.isEmpty()){
          int index  = S.peek();
          int index1 = S1.peek();
          if(index1<index) return false;
          else{ 
            S.pop();
            S1.pop();
          }
        }
        if(S.size()==0) return true;
    return false;
}
}