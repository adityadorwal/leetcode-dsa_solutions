class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int top = -1;

        for (int i = 0; i < n; i++) {

            while (top != -1 && temperatures[stack[top]] < temperatures[i])
            {
                int idx = stack[top--];
                temperatures[idx] = i-idx;
            }

            stack[++top] = i;
        }
        while(top != -1)temperatures[stack[top--]]=0;

        return temperatures;

    }
}