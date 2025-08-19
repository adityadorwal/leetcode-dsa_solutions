class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,sum=0,min_len=Integer.MAX_VALUE;
        while(right<nums.length)
        {
            sum+=nums[right];
            while(sum>=target)
            {
                min_len = Math.min(min_len , right - left+1);
                sum = sum - nums[left++];
            }
            right++;
        }
        if(min_len == Integer.MAX_VALUE)return 0;
        return min_len;
    }
}