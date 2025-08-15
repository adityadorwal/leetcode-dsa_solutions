class Solution {
    public boolean search(int[] nums, int target) {
        int left =0, right = nums.length-1;
        while(left<=right)
        {
            if(nums[left] == target || nums[right] ==target)return true;
            int mid = left + (right-left)/2;
            if(nums[mid]==target)return true;
            if(nums[mid] == nums[left] && nums[left] == nums[right])
            {
                left++;
                right--;
            }
            else if (nums[left] <= nums[mid])
            {
                if (nums[left] <= target && target < nums[mid])
                right = mid - 1;
                else 
                left = mid + 1;
            }
            else
            {
                if(target>nums[mid] && target<=nums[right])
                left = mid+1;
                else
                right = mid-1;
            }
        }
        return false;
    }
}