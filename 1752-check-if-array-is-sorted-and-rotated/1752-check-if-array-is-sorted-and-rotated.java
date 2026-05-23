class Solution {
    public boolean check(int[] nums) {
        int c=0;
        if(nums[nums.length-1]>nums[0])c++;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i-1]>nums[i])c++;
            if(c>1)return false;
        }
        return true;
    }
}