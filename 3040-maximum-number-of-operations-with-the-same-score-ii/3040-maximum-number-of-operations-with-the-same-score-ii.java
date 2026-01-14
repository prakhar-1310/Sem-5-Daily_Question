class Solution {
    public int maxOperations(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len+1];

        for( int i = 0; i <len; i++)
                Arrays.fill(dp[i], Integer.MIN_VALUE);

        return func(nums,0,len,-1,dp);
    }

    public int func(int[] nums, int st, int len, int score, int[][]dp)
    {
        if(len-st <= 1)
        {
            return 0;
        }

        int ans = 0;
        int ans1 = Integer.MIN_VALUE;
        int ans2 = Integer.MIN_VALUE;
        int ans3 = Integer.MIN_VALUE;

        if( dp[st][len]!= Integer.MIN_VALUE)
            return dp[st][len];

        if( score == -1)
        {
            ans1 = func(nums,st+2,len,nums[st]+nums[st+1],dp);
            ans2 = func(nums,st,len-2,nums[len-1]+nums[len-2],dp);
            ans3 = func(nums,st+1,len-1,nums[st]+nums[len-1],dp);
        }
        else
        {
            if((nums[st]+nums[st+1]) == score)
                ans1 = func(nums,st+2,len,score,dp);
            if(nums[len-1]+nums[len-2] == score)
                ans2 = func(nums,st,len-2,score,dp);
            if(nums[st]+nums[len-1] == score)
                ans3 = func(nums,st+1,len-1,score,dp);
        }

        ans = Math.max(ans1,Math.max(ans2,ans3));
        if (ans == Integer.MIN_VALUE)
        {
            dp[st][len] = 0;
            return 0;
        } 
        dp[st][len] = ans+1;
        return ans+1;
    }
}