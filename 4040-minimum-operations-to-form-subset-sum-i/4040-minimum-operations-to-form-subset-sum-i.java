class Solution {
    int n;
    int target;
    List<List<int[]>> states;

    int[][] dp;
    public int minOperations(int[] nums, int sum) {
        n = nums.length;
        target = sum;
        states = new ArrayList<>();

        for (int x : nums) {

            List<int[]> list = new ArrayList<>();

            int value = x;
            int operations = 0;

            while (value <= sum) {
                list.add(new int[]{value, operations});
                if (value > sum / 2) {
                    break;
                }
                value *= 2;
                operations++;
            }

            value = x / 2;
            operations = 1;

            while (value > 0) {
                list.add(new int[]{value, operations});
                value /= 2;
                operations++;
            }

            states.add(list);
        }

        dp = new int[n][sum + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = solve(0, 0);
        return ans == (int) 1e9 ? -1 : ans;
    }

    public int solve(int i, int curSum) {
        if (curSum == target) {
            return 0;
        }

        if (i == n || curSum > target) {
            return (int) 1e9;
        }

        if (dp[i][curSum] != -1) {
            return dp[i][curSum];
        }

        // Option 1: Don't select
        int ans = solve(i + 1, curSum);

        // Option 2: Select
        for (int[] state : states.get(i)) {

            int value = state[0];
            int operations = state[1];

            if (curSum + value <= target) {

                ans = Math.min(
                    ans,
                    operations + solve(i + 1, curSum + value)
                );
            }
        }

        return dp[i][curSum] = ans;
    }
}