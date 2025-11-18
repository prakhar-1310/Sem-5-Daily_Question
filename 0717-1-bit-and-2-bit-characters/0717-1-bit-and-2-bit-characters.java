class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int cnt=0;
        for(int i = bits.length-2;i>=0;i--){
            if(bits[i]==1){
                cnt++;
            }
            else{
                break;
            }
        }

        if(cnt%2==1){
            return false;
        }
        return true;

    }
}