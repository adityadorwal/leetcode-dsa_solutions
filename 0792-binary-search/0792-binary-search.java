class Solution {
    public int search(int[] nums, int target) {
        int s=0,l=nums.length-1,mid;
        while(s<=l)
        {
            mid = (s+l)/2;
            if(nums[mid] == target)return mid;
            else if(nums[mid] > target)l=mid-1;
            else s=mid+1;
        }
        return -1;
    }
}