class Solution {
    public void sortColors(int[] nums) {
        int left =0,right = nums.length-1,mid=0;
        while(mid<=right)
        {
            if(nums[mid]==0)
            {
                nums[mid] = nums[left];
                nums[left]=0;
                mid++;
                left++;
            }
            else if(nums[mid]==2)
            {
                nums[mid] = nums[right];
                nums[right] = 2;
                right--;
            }
            else
            mid++;
        }
    }
}