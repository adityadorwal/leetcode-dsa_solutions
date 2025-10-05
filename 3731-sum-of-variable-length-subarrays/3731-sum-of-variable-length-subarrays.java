class Solution {
    public int subarraySum(int[] nums) {
        int sum=nums[0];
        for(int i=1;i<nums.length;i++)
        {
            int s = Math.max(0,i-nums[i]);
            nums[i] = nums[i-1]+nums[i];
            if(s==0)s=0;
            else s=nums[s-1];
            sum += (nums[i]-s);
        }
        return sum;
    }
}