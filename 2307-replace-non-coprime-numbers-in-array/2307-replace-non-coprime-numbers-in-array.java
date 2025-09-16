class Solution {
    public long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack = new ArrayList<>();

        for (int num : nums) {
            long cur = num;
            // keep merging with previous numbers if gcd > 1
            while (!stack.isEmpty()) {
                long top = stack.get(stack.size() - 1);
                long g = gcd(cur, top);
                if (g == 1) break;
                cur = (cur * top) / g; // merge to LCM
                stack.remove(stack.size() - 1);
            }
            stack.add((int)cur);
        }
        return stack;
    }
}
