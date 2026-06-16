class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        cnt=0;
        helper(0, nums, target);
        return cnt;
    }
    static int cnt;
    public void helper(int i, int nums[], int tar){
        if(tar==0 && i==nums.length){
            cnt++;
            return;
        }

        if( i>=nums.length){
            return;
        }

        // opt1
        helper(i+1,nums, tar-nums[i]);
        helper(i+1,nums, tar+nums[i]);
    }
}