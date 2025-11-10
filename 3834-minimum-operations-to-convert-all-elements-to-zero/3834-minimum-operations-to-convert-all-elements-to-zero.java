class Solution {
    public int minOperations(int[] nums) {
        int ops = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int num : nums) {
            // pop while current < stack top
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            // if current > stack top => new operation
            if (stack.isEmpty() || stack.peek() < num) {
                ops++;
                stack.push(num);
            }
            // if equal, do nothing
        }
        return ops;
    }
}
