class Solution {
    public int maximumXOR(int[] nums) {
        int xor=0;
        int ans=0;
        for(int i : nums){
            ans|=i;
        }

        return ans;
    }
}