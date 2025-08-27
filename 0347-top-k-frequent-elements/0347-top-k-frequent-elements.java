class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequencies
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i: nums) map.put(i, map.getOrDefault(i,0)+1);

        // Step 2: MinHeap comparing by frequency
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (a, b) -> map.get(a) - map.get(b)
        );

        // Step 3: Keep only k most frequent
        for(int num: map.keySet()) {
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll(); // remove lowest frequency
            }
        }

        // Step 4: Extract result
        int[] result = new int[k];
        int idx = 0;
        while(!minHeap.isEmpty()) {
            result[idx++] = minHeap.poll();
        }
        return result;
    }
}