class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int z = 0;
        int one = 0;
        if(bits[bits.length-1]!=0){
            return false;
        }
        for(int i=0;i<bits.length;){
            if(bits[i]==0){
                i++;
                continue;
            }
            else{
                i+=2;
                if(i>=bits.length){
                    return false;
                }
            }
        }
        return true;

    }
}