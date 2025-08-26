class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int limit;
    public KthLargest(int k, int[] nums) {
        limit = k;
        for(int i:nums)
        {
            if(limit<=0)
            {
                if(minHeap.peek()<i)
                {
                    minHeap.poll();
                    minHeap.offer(i);
                }
            }
            else
            {
                minHeap.offer(i);
                limit --;
            }
        }
    }
    
    public int add(int val) {
        if(limit <= 0)
        {
            if(minHeap.peek()<val)
            {
                minHeap.poll();
                minHeap.offer(val);
            }
        }
        else
        {
            limit--;
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */