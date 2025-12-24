class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int i:capacity)pq.offer(i);
        int sum=0;
        int result=0;
        for(int i:apple)
        {
            sum = sum+i;
            while(sum>0)
            {
                sum = sum-pq.poll();
                result++;
            }
        }
        return result;
    }
}