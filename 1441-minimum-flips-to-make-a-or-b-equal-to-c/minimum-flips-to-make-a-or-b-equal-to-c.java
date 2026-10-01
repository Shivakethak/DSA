class Solution {
    public int minFlips(int a, int b, int c) {
        int act = a | b;
        int des = c ;
        int and = act ^ c;
        int And = (a & b) & (and);
        int count = 0;
        for(int i=0;i<32;i++){
            if((and & (1<<i))!=0){
                count++;
            }
            if((And & (1<<i))!=0){
                count++;
            }
        }
        return count;
           }
}