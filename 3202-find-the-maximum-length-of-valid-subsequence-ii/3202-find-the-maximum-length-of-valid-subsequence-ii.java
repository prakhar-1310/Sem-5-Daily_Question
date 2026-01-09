class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        if (n == 2 || k == 1) return n;
        
        // dp[i][r] = length of subsequence ending at i with pair-sum remainder r
        int[][] dp = new int[n][k];
        int ans = 0;
        
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int rem = (nums[j] + nums[i]) % k;
                // extend subsequence ending at j with same remainder rem
                dp[i][rem] = Math.max(dp[i][rem], dp[j][rem] + 1);
                ans = Math.max(ans, dp[i][rem]);
            }
        }
        return ans + 1; // +1 because dp counts pairs, we want elements
    }
}