class Solution {
    public int jump(int[] nums) {
        int dp[] = new int [nums.length];
        Arrays.fill(dp,-1);
        return helper(nums,0,dp);
    }

    public int helper(int nums[],int idx, int dp[]){
        if(idx>=nums.length-1){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int ans=1000000;
        for(int i=1;i<=nums[idx];i++){
            ans = Math.min(ans,helper(nums,idx+i,dp));
        }

        return dp[idx]=ans+1;
    }
}