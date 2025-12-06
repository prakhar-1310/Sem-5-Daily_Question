class Solution {
    public int countPartitions(int[] nums, int k) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 2];
        dp[0] = 1;
        prefix[1] = 1;

        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        int l = 0;

        for (int i = 0; i < n; i++) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }

            maxQ.addLast(i);
            minQ.addLast(i);

            while (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > k) {
                if (maxQ.peekFirst() == l) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() == l) {
                    minQ.pollFirst();
                }
                l++;
            }

            dp[i + 1] = (prefix[i + 1] - prefix[l] + MOD) % MOD;
            prefix[i + 2] = (prefix[i + 1] + dp[i + 1]) % MOD;
        }
        return (int) dp[n];
    }
}