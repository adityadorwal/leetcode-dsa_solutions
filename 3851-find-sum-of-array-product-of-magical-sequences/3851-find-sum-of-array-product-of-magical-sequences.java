class Solution {
    static final long MOD = 1_000_000_007L;

    public int magicalSum(int m, int k, int[] nums) {
        int n = nums.length;

        // factorials & inverse factorials
        long[] fact = new long[m + 1];
        long[] invFact = new long[m + 1];
        fact[0] = 1;
        for (int i = 1; i <= m; ++i) fact[i] = fact[i - 1] * i % MOD;
        invFact[m] = modPow(fact[m], MOD - 2);
        for (int i = m - 1; i >= 0; --i) invFact[i] = invFact[i + 1] * (i + 1) % MOD;

        // precompute powers nums[i]^c
        long[][] powNums = new long[n][m + 1];
        for (int i = 0; i < n; ++i) {
            powNums[i][0] = 1;
            long base = (nums[i] % MOD + MOD) % MOD;
            for (int c = 1; c <= m; ++c) {
                powNums[i][c] = powNums[i][c - 1] * base % MOD;
            }
        }

        // dp[picked][carry][ones] = sum of weights (product of nums^c / c!) for processed indices
        long[][][] dp = new long[m + 1][m + 1][k + 1];
        dp[0][0][0] = 1;

        for (int idx = 0; idx < n; ++idx) {
            long[][][] ndp = new long[m + 1][m + 1][k + 1];
            for (int picked = 0; picked <= m; ++picked) {
                for (int carry = 0; carry <= m; ++carry) {
                    for (int ones = 0; ones <= k; ++ones) {
                        long cur = dp[picked][carry][ones];
                        if (cur == 0) continue;

                        // choose c for current index, but don't exceed total m picks
                        int maxC = m - picked;
                        for (int c = 0; c <= maxC; ++c) {
                            int total = carry + c;
                            int bit = total & 1;
                            int newOnes = ones + bit;
                            if (newOnes > k) continue;
                            int newCarry = total >> 1;
                            if (newCarry > m) continue;

                            long weight = powNums[idx][c] * invFact[c] % MOD;
                            ndp[picked + c][newCarry][newOnes] = (ndp[picked + c][newCarry][newOnes] + cur * weight) % MOD;
                        }
                    }
                }
            }
            dp = ndp;
        }

        long ans = 0;
        // only consider states where we've picked exactly m items
        for (int carry = 0; carry <= m; ++carry) {
            int pop = Integer.bitCount(carry);
            for (int ones = 0; ones <= k; ++ones) {
                if (ones + pop == k) {
                    ans = (ans + dp[m][carry][ones]) % MOD;
                }
            }
        }

        ans = ans * fact[m] % MOD; // multiply by m! for ordering permutations
        return (int) ans;
    }

    private long modPow(long a, long e) {
        long res = 1;
        a %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) res = res * a % MOD;
            a = a * a % MOD;
            e >>= 1;
        }
        return res;
    }
}
