class Solution {
    public int[] finalPrices(int[] prices) {

        int n = prices.length;
        int[] stack = new int[n];   // manual stack of indices
        int top = -1;               // stack pointer

        for (int i = 0; i < n; i++) {

            while (top != -1 && prices[stack[top]] >= prices[i]) {
                int idx = stack[top--];
                prices[idx] -= prices[i];
            }

            stack[++top] = i; // push index
        }

        return prices;
    }
}
