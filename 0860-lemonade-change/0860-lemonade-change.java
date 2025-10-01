class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five=0;
        int ten=0;
        // we are not keeping count of no. of 20 notes, as 20 notes are not required for giving a change
        for(int i=0;i<bills.length;i++){
            if(bills[i]==5){
                five++;
            }
            else if(bills[i]==10){
                if(five>0){
                    five--;
                    ten++;
                }
                else{
                    return false;
                }
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                }
                else if(five>2){
                    five-=3;
                }
                else{
                    return false;
                }
            }
        }

        return true;
    }
}