class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int ans = 1;
        int adjustable = 0;
        Map<Integer, Integer> count = new HashMap<>();
        // TreeMap for line sweep, storing the change in adjustability count
        TreeMap<Integer, Integer> line = new TreeMap<>();
        TreeSet<Integer> candidates = new TreeSet<>();

        for (final int num : nums) {
            count.merge(num, 1, Integer::sum);
            // Start of range for elements that can be adjusted to 'num'
            line.merge(num - k, 1, Integer::sum);
            // End of range (exclusive)
            line.merge(num + k + 1, -1, Integer::sum);
            
            candidates.add(num);
            candidates.add(num - k);
            candidates.add(num + k + 1);
        }

        // Iterate through all unique points that matter in a sorted order
        for (final int num : candidates) {
            adjustable += line.getOrDefault(num, 0);
            final int countNum = count.getOrDefault(num, 0);
            
            // adjusted: the number of other elements that can be adjusted to 'num'
            final int adjusted = adjustable - countNum; 
            
            // Max frequency is current count + minimum of (allowed operations, needed adjustments)
            ans = Math.max(ans, countNum + Math.min(numOperations, adjusted));
        }
        
        return ans;
    }
}