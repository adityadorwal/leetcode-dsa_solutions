import java.util.*;

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> memo = new HashMap<>();
        // We add 1 because the top call counts “+1 partition” implicitly via the logic (fresh start)
        return dfs(s, 0, true, 0, k, memo) + 1;
    }

    // dfs returns max number of *additional* partitions from index i given state
    private int dfs(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> memo) {
        int n = s.length();
        if (i == n) {
            return 0;
        }
        long key = (((long)i) << 27) | ((canChange ? 1L : 0L) << 26) | mask;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // Option 1: don’t change at this index, treat s.charAt(i)
        int c = s.charAt(i) - 'a';
        int res = getRes(s, i, canChange, mask, 1 << c, k, memo);

        // Option 2: change this character (if still allowed)
        if (canChange) {
            for (int x = 0; x < 26; x++) {
                // try changing current character to letter x
                int bit = 1 << x;
                res = Math.max(res, getRes(s, i, false, mask, bit, k, memo));
            }
        }

        memo.put(key, res);
        return res;
    }

    private int getRes(String s, int i, boolean nextCanChange, int mask, int newBit, int k,
                       Map<Long, Integer> memo) {
        int newMask = mask | newBit;
        if (Integer.bitCount(newMask) > k) {
            // If adding this character causes > k distinct, we must start a new partition:
            // So this character becomes the first of next partition (mask resets to newBit)
            return 1 + dfs(s, i + 1, nextCanChange, newBit, k, memo);
        } else {
            // Still within same partition
            return dfs(s, i + 1, nextCanChange, newMask, k, memo);
        }
    }
}
