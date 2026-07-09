class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] group = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                group[i] = group[i - 1];
            } else {
                group[i] = group[i - 1] + 1;
            }
        }

        boolean[] ans = new boolean[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = group[queries[i][0]] == group[queries[i][1]];
        }

        return ans;
    }
}