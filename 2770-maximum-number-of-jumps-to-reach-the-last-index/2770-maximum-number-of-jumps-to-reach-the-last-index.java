// Top-Down DP + Memoization Approach

class Solution {

    int n;

    // Recursive function to find maximum jumps from index i
    public int solve(int i, int[] nums, int target, int[] dp) {

        // If we reach last index
        if(i == n - 1)
            return 0;

        // Return already computed result
        if(dp[i] != -2)
            return dp[i];

        int ans = -1;

        // Try all possible next jumps
        for(int j = i + 1; j < n; j++) {

            // Check jump condition
            if(Math.abs(nums[j] - nums[i]) <= target) {

                int temp = solve(j, nums, target, dp);

                // Update maximum jumps
                if(temp != -1) {
                    ans = Math.max(ans, 1 + temp);
                }
            }
        }

        // Store and return answer
        return dp[i] = ans;
    }

    public int maximumJumps(int[] nums, int target) {

        n = nums.length;

        // -2 means not calculated yet
        int[] dp = new int[n];
        Arrays.fill(dp, -2);

        return solve(0, nums, target, dp);
    }
}