class Solution {
    public boolean sumGame(String num) {
        int left=0;
        int right=0;
        int sumL=0;
        int sumR=0;

        int len = num.length();

        for(int i=0;i<len; i++){
            char ch = num.charAt(i);
            if(i<len/2){
                if(ch=='?'){
                    left++;
                }
                else{
                    sumL+=(ch-'0');
                }
            }
            else{
                if(ch=='?'){
                    right++;
                }
                else{
                    sumR+=(ch-'0');
                }

            }
        }
        int tot = left+right;
        
        if(tot%2!=0 || (sumL + 4.5*left)!=(sumR + 4.5*right)) return true;
        return false;
    }
}