class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_ones=0,c=0;
        for (int i: nums)
        {
            if(i==1)c++;
            else 
            {
                max_ones = Math.max(c,max_ones);
                c=0;
            }
        }
        return Math.max(c,max_ones);
    }
}