class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int []> stk = new Stack<>();
        int result=0;
        int pre=0;
        for(int i=0;i<heights.length;i++)
        {
            int num = heights[i];
            pre=i;
            while(!stk.isEmpty() && stk.peek()[0]>num)
            {
                int arr[] = stk.pop();
                pre = arr[1];
                result = Math.max(result,  arr[0]*(i-pre));
            }
            stk.push(new int[]{num,pre,i});
            // result = Math.max(result,num);
        }
        while(!stk.isEmpty())
        {
            int arr[] = stk.pop();
            result = Math.max(result,arr[0]*(heights.length-arr[1]));
        }
        
        return result;
    }
}