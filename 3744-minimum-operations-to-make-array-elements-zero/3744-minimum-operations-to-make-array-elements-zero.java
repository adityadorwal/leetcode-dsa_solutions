class Solution {
    public long minOperations(int[][] queries) {
        long total = 0;

        for (int[] q : queries) {
            int l = q[0], r = q[1];
            // For each query, use the helper function
            total += (getOperations(r) - getOperations(l - 1) + 1) / 2;
        }

        return total;
    }

    private long getOperations(long n) {
        long res = 0;
        long ops = 0;
        long powerOfFour = 1;

        while (powerOfFour <= n) {
            long left = powerOfFour;
            long right = Math.min(n, powerOfFour * 4 - 1);

            ops++;  // Number of operations needed for this "bucket"
            res += (right - left + 1) * ops;

            powerOfFour *= 4;  // Go to next power-of-four segment
        }

        return res;
    }
}
