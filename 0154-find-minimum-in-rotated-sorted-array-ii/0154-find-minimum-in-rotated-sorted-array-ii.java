class Solution {
    public int findMin(int[] nums) {
        int left=0, right = nums.length-1;
        if(nums[left]<nums[right] )return nums[0];
        while(left<right-1)
        {
            int mid = (left+right)/2;
            if(nums[left]==nums[mid])left++;
            else if(nums[right] == nums[mid])right--;
            else if(nums[left]>nums[mid])right=mid;
            else left=mid;
        }
        return nums[right]>nums[left]?nums[left]:nums[right];
    }
}