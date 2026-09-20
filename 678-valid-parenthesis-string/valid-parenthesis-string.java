class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[] arr = new int[n];
        Stack<Integer> S = new Stack<>();
        for(int i=0 ; i<n ; i++){
            if(s.charAt(i)=='('){
                S.push(i);
            }else if (s.charAt(i)==')'){
                if(S.size()==0){
                    int j = i-1;
                    boolean present = false;
                    while(j>=0){
                       if(arr[j]==1){ 
                        present = true;
                        arr[j] = 0;
                        break;
                       }
                       j--;
                    }
                    if(present==false) return false;
                }else{
                    S.pop();
                }
            }else{
                arr[i]=1;
            }
        }
        if(S.size()==0) return true;
        int i = 0 ; 
        while(!S.isEmpty()){
          int index  = S.peek();
          int j = index+1;
          boolean present   = false;
          while(j<n){
            if(arr[j]==1){ 
                S.pop();
                arr[j] = 0;
                present = true;
                break;
          }
          j++;
        }
        if(present == false ) return false;
    }
    return true;
}
}