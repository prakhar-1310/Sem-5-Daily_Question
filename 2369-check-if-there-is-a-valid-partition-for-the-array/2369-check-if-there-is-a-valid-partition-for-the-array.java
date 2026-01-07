class Solution {
    public boolean validPartition(int[] nums) {
        Boolean dp[] = new Boolean[nums.length];
        return helper(0,nums,dp);
    }

    public boolean helper(int i, int nums[], Boolean dp[]){
        if(i>=nums.length){
            return true;
        }

        if(dp[i]!=null){
            return dp[i];
        }

        boolean ans=false;

        if(i+1<nums.length && nums[i]==nums[i+1]){
            ans = ans || helper(i+2,nums,dp);
        }

        if(i+2<nums.length && nums[i]==nums[i+1] && nums[i+1]==nums[i+2]){
            ans = ans || helper(i+3, nums,dp);
        }

        if(i+2<nums.length && nums[i]+1==nums[i+1] && nums[i]+2==nums[i+2]){
            ans = ans || helper(i+3,nums,dp);
        }

        return dp[i]=ans;
    }
}