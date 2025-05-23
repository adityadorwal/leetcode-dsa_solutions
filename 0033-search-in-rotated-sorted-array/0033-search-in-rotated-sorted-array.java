class Solution {
    public int search(int[] nums, int target) {
        int left=0,right=nums.length-1,i,mid;
        while(left<=right)
        {
            mid=(left+right)/2;
            if(nums[mid]==target)
            return mid;
            if(nums[left]<=nums[mid])
            {
                if(nums[left]<=target && target<nums[mid])
                right=mid-1;
                else
                left=mid+1;
            }
            else
            {
                if(nums[right]>=target && target>nums[mid])
                left=mid+1;
                else
                right=mid-1;
            }
        }
        return(-1);
    }
}