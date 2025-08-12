class Solution {
    public int numberOfWays(int n, int x) {
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1; 
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            int power = (int) Math.pow(i, x);
            for (int sum = n; sum >= power; sum--) {
            dp[sum] = (dp[sum] + dp[sum - power]) % mod;
            }
        }
        return (int) dp[n];
    }
}