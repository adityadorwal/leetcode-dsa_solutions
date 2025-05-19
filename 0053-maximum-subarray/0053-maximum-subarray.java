class Solution {
    public int maxSubArray(int[] nums) {
        int i,currsum=nums[0],maxsum=nums[0];
        for(i=1;i<nums.length;i++)
        {
            currsum=Math.max(nums[i],nums[i]+currsum);
            maxsum=Math.max(maxsum,currsum);
        }
        return(maxsum);
    }
}