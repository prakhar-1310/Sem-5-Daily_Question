class Solution {
    public int maximumXOR(int[] nums) {
        int xor=0;
        int ans=0;
        for(int i : nums){
            for(int j=0;j<=32;j++){
                int mask = 1<<j;
                if((mask&i)!=0){
                    ans|=mask;
                }
            }
        }

        return ans;
    }
}