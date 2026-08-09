class Solution {
    int[][] dp;
    int[] suffix;

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        dp = new int[n][n + 1];
        suffix = new int[n + 1];

        // suffix[i] = sum of piles from i to n-1
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        return helper(0, 1, piles);
    }

    public int helper(int i, int m, int[] piles) {

        if (i >= piles.length) {
            return 0;
        }

        if (2 * m >= piles.length - i) {
            return suffix[i];
        }

        if (dp[i][m] != 0) {
            return dp[i][m];
        }

        int ans = 0;
        int sum = 0;

        for (int x = 1; x <= 2 * m && i + x <= piles.length; x++) {

            sum += piles[i + x - 1];

            int newM = Math.max(m, x);

            int opponent = helper(i + x, newM, piles);

            int current = sum + (suffix[i + x] - opponent);

            ans = Math.max(ans, current);
        }

        return dp[i][m] = ans;
    }
}
