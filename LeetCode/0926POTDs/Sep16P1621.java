public class Sep16P1621 {
    public int numberOfSets(int n, int k) {
        long MOD = 1_000_000_007;
        int total = n + k - 1;
        int select = 2 * k;

        if (select > total)
            return 0;

        long num = 1;
        long den = 1;

        for (int i = 0; i < select; i++) {
            num = (num * (total - i)) % MOD;
            den = (den * (i + 1)) % MOD;
        }

        return (int) ((num * inverse(den, MOD)) % MOD);
    }

    private long inverse(long b, long mod) {
        return power(b, mod - 2, mod);
    }

    private long power(long b, long exp, long mod) {
        long res = 1;
        b %= mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * b) % mod;
            }
            b = (b * b) % mod;
            exp /= 2;
        }
        return res;
    }
}
