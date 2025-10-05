class Solution {
    public int countPartitions(int[] nums) {
        for(int i=1;i<nums.length;i++) nums[i] = nums[i-1]+nums[i];
        int k=nums[nums.length-1];
        int c=0;
        for(int i=0;i<nums.length-1;i++)
        {
            if((nums[i]-(k-nums[i]))%2 == 0)c++;
        }
        return c;
    }
}