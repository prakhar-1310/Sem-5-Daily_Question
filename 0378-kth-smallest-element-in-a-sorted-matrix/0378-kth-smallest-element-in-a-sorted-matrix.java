class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[n - 1][m - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;

            int cnt = helper(mid, matrix);

            if (cnt >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int helper(int mid, int[][] matrix) {
        int cnt = 0;

        int n = matrix.length;
        int m = matrix[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] <= mid) {
                    cnt++;
                } else {
                    break;
                }
            }
        }

        return cnt;
    }
}