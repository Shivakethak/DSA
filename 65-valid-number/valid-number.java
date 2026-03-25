class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean numSeen = false;
        boolean dotSeen = false;
        boolean eSeen = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (Character.isDigit(c)) {
                numSeen = true;
            } 
            else if (c == '+' || c == '-') {
                // sign only allowed at start or after e/E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } 
            else if (c == '.') {
                // dot only once and not after e/E
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            } 
            else if (c == 'e' || c == 'E') {
                // e only once and must come after a number
                if (eSeen || !numSeen) {
                    return false;
                }
                eSeen = true;
                numSeen = false; // must see a number after e
            } 
            else {
                return false;
            }
        }
        
        return numSeen;
    }
}