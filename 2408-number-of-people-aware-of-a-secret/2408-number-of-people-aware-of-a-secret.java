class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        final int MOD = 1_000_000_007;
        int[] dp = new int[n + 1]; // dp[i] = number of people who learn on day i
        dp[1] = 1;

        long window = 0; // sum of dp[i] for i in [d - forget + 1 .. d - delay] for current day d

        for (int d = 2; d <= n; d++) {
            int addIdx = d - delay;   // index that enters the window for day d
            if (addIdx >= 1) {
                window = (window + dp[addIdx]) % MOD;
            }
            int removeIdx = d - forget; // index that leaves the window before day d
            if (removeIdx >= 1) {
                window = (window - dp[removeIdx] + MOD) % MOD;
            }
            dp[d] = (int) window;
        }

        long ans = 0;
        for (int d = Math.max(1, n - forget + 1); d <= n; d++) {
            ans = (ans + dp[d]) % MOD;
        }
        return (int) ans;
    }
}
