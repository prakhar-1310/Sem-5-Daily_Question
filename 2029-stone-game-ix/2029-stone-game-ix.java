class Solution {
    public boolean stoneGameIX(int[] stones) {
        int zero=0;
        int one=0;
        int two=0;
        for(int i :stones){
            if(i%3==0){
                zero++;
            }
            else if(i%3==1){
                one++;
            }
            else{
                two++;
            }
        }

        if(zero%2==0){
            if(one>0 && two>0)return true;
            else return false;
        }
        else{
            if(Math.abs(one-two)>2)return true;
            return false;
        }
    }

}