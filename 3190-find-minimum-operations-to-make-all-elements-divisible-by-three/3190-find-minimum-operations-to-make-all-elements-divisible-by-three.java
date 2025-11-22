class Solution {
    public int minimumOperations(int[] nums) {
        int count=0;
        for(int i:nums)
        {
            int rem = i%3;
            count += (rem<(3-rem))?rem:(3-rem);
        }
        return count;
    }
}