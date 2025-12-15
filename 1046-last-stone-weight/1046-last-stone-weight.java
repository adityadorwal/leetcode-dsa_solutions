class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)-> b-a);
        for(int i:stones)maxHeap.offer(i);
        while(maxHeap.size()>1)
        {
            int clash = maxHeap.poll()-maxHeap.poll();
            if(clash != 0)maxHeap.offer(clash);
        }
        if(maxHeap.size()==0)return 0;
        return maxHeap.poll();
    }
}