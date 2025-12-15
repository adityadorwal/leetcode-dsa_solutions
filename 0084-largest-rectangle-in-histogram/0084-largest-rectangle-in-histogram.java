class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<int []> stk = new ArrayDeque<>();
        int result=0;
        int pre=0;
        int n=heights.length;
        for(int i=0;i<n;i++)
        {
            int num = heights[i];
            pre=i;
            while(!stk.isEmpty() && stk.peek()[0]>num)
            {
                int arr[] = stk.pop();
                pre = arr[1];
                result = Math.max(result,  arr[0]*(i-pre));
            }
            stk.push(new int[]{num,pre});
        }
        while(!stk.isEmpty())
        {
            int arr[] = stk.pop();
            result = Math.max(result,arr[0]*(n-arr[1]));
        }
        return result;
    }
}