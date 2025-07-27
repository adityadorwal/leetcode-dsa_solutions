class Solution {
    public int searchInsert(int[] nums, int target) {
        int s=0,l=nums.length-1,mid=0;
        while(s<=l)
        {
            mid = (s+l)/2;
            if(nums[mid] == target)return mid;
            else if (nums[mid]<target)s=mid+1;
            else l=mid-1;
        }
        return s;
    }
}