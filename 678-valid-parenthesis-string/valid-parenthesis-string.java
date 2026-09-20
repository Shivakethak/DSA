class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> S = new Stack<>();
        Stack<Integer> S1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                S.push(i);
            } else if (s.charAt(i) == ')') {
                if (!S.isEmpty()) {
                     S.pop();
                }
                else if (S1.isEmpty()) {
                    return false;
                }
                else{
                    S1.pop();
                }
            }  else {
                S1.push(i);
            }
        }
        while (!S.isEmpty() && !S1.isEmpty()) {
            int index = S.pop();
            int index1 = S1.pop();
            if (index1 < index){
                return false;
            }
        }
        return S.isEmpty();
    }
}