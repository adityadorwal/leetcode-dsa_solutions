class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0, n = heights.length;

        for (int i = 0; i <= n; i++) {
            int height = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() && height < heights[stack.peek()]) {
                int topIndex = stack.pop();
                int h = heights[topIndex];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * width);
            }

            stack.push(i);
        }

        return max;
    }
}
