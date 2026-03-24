class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        final int MOD = 12345;
        int n = grid.length, m = grid[0].length;

        // Flatten grid
        int N = n * m;
        int[] arr = new int[N];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[idx++] = grid[i][j] % MOD;
            }
        }

        // Prefix and suffix arrays
        int[] prefix = new int[N];
        int[] suffix = new int[N];

        for (int i = 0; i < N; i++) {
            prefix[i] = 1;
            suffix[i] = 1;
        }

        // Build prefix
        for (int i = 1; i < N; i++) {
            prefix[i] = (int)((1L * prefix[i - 1] * arr[i - 1]) % MOD);
        }

        // Build suffix
        for (int i = N - 2; i >= 0; i--) {
            suffix[i] = (int)((1L * suffix[i + 1] * arr[i + 1]) % MOD);
        }

        // Build result
        int[][] res = new int[n][m];
        idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res[i][j] = (int)((1L * prefix[idx] * suffix[idx]) % MOD);
                idx++;
            }
        }

        return res;
    }
}