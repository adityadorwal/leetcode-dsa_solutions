class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stk = new ArrayDeque<>();
        int len=temperatures.length;
        int []result = new int[len];
        for(int i=0;i<len;i++)
        {
            while(!stk.isEmpty() && temperatures[i] > temperatures[stk.peek()])
            {
                int k=stk.pop();
                result[k]=i-k;
            }
            stk.push(i);
        }
        return result;
    }
}