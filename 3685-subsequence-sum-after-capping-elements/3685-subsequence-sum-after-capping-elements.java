class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] ans = new boolean[n];
        Arrays.sort(nums);
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        int i = 0;

        for (int x = 1; x <= n; x++) {
            for (; i < n && nums[i] < x; i++) {
                for (int j = k; j >= nums[i]; j--) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
            int ncapped = n - i;
            for (int j = 0; j <= ncapped; j++) {
                int times = j * x;
                if (times > k) {
                    break;
                }
                if (dp[k - times]) {
                    ans[x - 1] = true;
                    break;
                }
            }

        }
        return ans;
    }
}