class Solution {
    public int rob(int[] nums) {
        int dp[] = new int [nums.length];
        Arrays.fill(dp,-1);
        // we cannot will zero as value of a house can be zero given in constraint
        return helper(dp,nums,0);
    }

    public static int helper(int dp[], int nums[], int idx){
        if(idx >=nums.length){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int a = nums[idx] + helper(dp,nums,idx+2);
        int b = helper(dp,nums,idx+1);
        dp[idx]=Math.max(a,b);
        return Math.max(a,b);
    }
}