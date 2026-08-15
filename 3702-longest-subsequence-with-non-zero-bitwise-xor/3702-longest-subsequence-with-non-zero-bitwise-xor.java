class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        int cnt=0;
        for(int i : nums){
            xor^=i;
            if(i!=0){
                cnt++;
            }
        }

        if(xor!=0) return nums.length;

        if(cnt!=0)return nums.length-1;

        return 0;
    }
}