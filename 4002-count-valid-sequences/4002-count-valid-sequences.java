class Solution {
        int MOD = 1000000007;
    long power(long b, long e) {
        long r = 1;
        for (; e > 0; e >>= 1, b = b * b % MOD)
            if ((e & 1) == 1) r = r * b % MOD;
        return r;
    }
    long comb(int n, int k) {
        if (k < 0 || k > n) return 0;
        k = Math.min(k, n - k);
        long res = 1, den = 1;
        for (int i = 1; i <= k; ++i) {
            res = res * (n - i + 1) % MOD;
            den = den * i % MOD;
        }
        return res * power(den, MOD - 2) % MOD;
    }

    public int countValidSequences(int n, int k) {
        long res = comb(n - 1, k - 1);
        if (n % 2 == k % 2)
            res = (res - comb((n + k) / 2 - 1, k - 1) + MOD) % MOD;
        return (int) res;
    }
}