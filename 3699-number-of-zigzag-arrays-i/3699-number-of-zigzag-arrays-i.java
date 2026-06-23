class Solution {
    public int zigZagArrays(int n, int l, int r) {
        if (n == 1) return r - l + 1;

        int MOD = 1_000_000_007;

        long[] inc = new long[r + 2];
        long[] dec = new long[r + 2];

        for (int x = l; x <= r; x++) {
            inc[x] = 1;
            dec[x] = 1;
        }

        for (int len = 2; len <= n; len++) {
            long[] newInc = new long[r + 2];
            long[] newDec = new long[r + 2];

            // Prefix sum for increasing transitions
            long prefix = 0;
            for (int x = l; x <= r; x++) {
                newInc[x] = prefix;
                prefix = (prefix + dec[x]) % MOD;
            }

            // Suffix sum for decreasing transitions
            long suffix = 0;
            for (int x = r; x >= l; x--) {
                newDec[x] = suffix;
                suffix = (suffix + inc[x]) % MOD;
            }

            inc = newInc;
            dec = newDec;
        }

        long ans = 0;

        for (int x = l; x <= r; x++) {
            ans = (ans + inc[x] + dec[x]) % MOD;
        }

        return (int) ans;
    }
}