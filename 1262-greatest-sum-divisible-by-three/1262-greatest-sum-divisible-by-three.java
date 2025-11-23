class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[][] = new int[nums.length][3];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        return helper(nums,0,0,dp);
    }

    public int helper(int nums[], int i, int rem, int dp[][]){
        if( i==nums.length && rem%3==0){
            return 0;
        }
        if(i>=nums.length){
            return Integer.MIN_VALUE/2;
        }

        if(dp[i][rem]!=-1){
            return dp[i][rem];
        }

        int ans=0;
        int opt1 = nums[i]+ helper(nums,i+1,(rem+nums[i])%3,dp);
        int opt2 = helper(nums,i+1,rem,dp);
        
        ans = Math.max(opt1,opt2);

        return dp[i][rem] = ans;
    }
}