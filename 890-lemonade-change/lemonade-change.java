class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five =0;
        int tens= 0;
        int twenty =0;
        for(int i=0;i<n;i++){
            if(bills[i]==5) five+=1;
            else if(bills[i]==10){
                tens+=1;
                if(five>0) five-=1;
                else return false;
            }
            else{
                twenty+=1;
                if(tens>0 && five>0 ){
                tens-=1;
                five-=1;
                }
                else if(five>=3){
                    five-=3;
                }else{
                    return false;
            }
            }
        }
        return true ;
    }
}