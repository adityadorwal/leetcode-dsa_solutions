class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque <Integer> q = new ArrayDeque<Integer>();
        int len=nums.length,a=0;
        int [] result = new int[len-k+1];
        for(int i=0;i<len;i++)
        {
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])q.removeLast();
            q.addLast(i);
            if(q.peekFirst()<i-k+1)q.removeFirst();
            if(i+1>=k)result[i-k+1]=nums[q.peekFirst()];
        }
        return result;
    }
}