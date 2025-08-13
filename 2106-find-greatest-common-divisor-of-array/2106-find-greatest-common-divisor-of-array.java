class Solution {
    public int findGCD(int[] nums) {
        int min=nums[0],max=0;
        for(int i:nums)
        {
            min = Math.min(min,i);
            max = Math.max(max,i);
        }
        while(min!=0)
        {
            int t = min;
            min = max%min;
            max = t;
        }
        return max;
    }
}