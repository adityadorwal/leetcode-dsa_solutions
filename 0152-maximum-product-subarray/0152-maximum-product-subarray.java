class Solution {
    public int maxProduct(int[] nums) {
        int current_max=nums[0],current_min=nums[0],max_product=nums[0],temp,i;
        for(i=1;i<nums.length;i++)
        {
            temp = current_max;
            current_max =Math.max(nums[i], Math.max(nums[i] * current_max, nums[i] * current_min));
            current_min = Math.min(nums[i], Math.min(nums[i] * temp, nums[i] * current_min));
            max_product=Math.max(current_max,max_product);
        }
        return(max_product);
    }
}