class Solution {
    static final long MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        long max = (1L << p) - 1;          // 2^p - 1
        long second = max - 1;             // 2^p - 2
        long exp = (1L << (p - 1)) - 1;    // 2^(p-1) - 1

        long power = modPow(second, exp);
        long ans = (max % MOD * power) % MOD;

        return (int) ans;
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;

        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
