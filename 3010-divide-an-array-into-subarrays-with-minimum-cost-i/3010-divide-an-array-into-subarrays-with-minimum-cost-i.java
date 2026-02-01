class Solution {
    public int minimumCost(int[] nums) {
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        for(int i=3;i<nums.length;i++)
        {
            if(nums[i]<b)
            {
                if(b<c)c=b;
                b=nums[i];
            }
            else if(nums[i]<c)c=nums[i];
        }
        return a+b+c;
    }
}