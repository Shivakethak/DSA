class Solution {
    public static int getFirstSetBit(int n) {
      int and = n & (-n);
      for(int i=0;i<32;i++){
          int bit = (and>>i) & 1;
          if(bit==1) return i+1;
      }
      return 0;
    }
}