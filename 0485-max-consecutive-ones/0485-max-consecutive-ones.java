class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones=0,c=0;
        for (int i: nums)
        {
            if(i==1)c++;
            else c=0;
            max_ones = Math.max(c,max_ones);
        }
        return max_ones;
    }
}