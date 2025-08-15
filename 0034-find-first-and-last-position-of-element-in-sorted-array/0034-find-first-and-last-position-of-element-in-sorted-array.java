class Solution {
    public int[] search(int [] nums, int target, int left , int right)
    {
        int arr[] = new int[]{-1,-1};
        if(left <= right)
        {
            int mid = left + (right-left)/2;
            if(nums[mid] == target)
            {
                int left_arr[] = search(nums , target , left , mid-1);

                if(left_arr[0] ==-1)arr[0] = mid;
                else arr[0] = left_arr[0];

                int right_arr[] = search(nums , target , mid+1 , right);
                
                if(right_arr[1] ==-1)arr[1] = mid;
                else arr[1] = right_arr[1];
            }
            else if(nums[mid] < target) return search(nums,target,mid+1,right);
            else return search(nums,target,left,mid-1);
        }
        return arr;
    }
    public int[] searchRange(int[] nums, int target) {
        return search(nums,target,0,nums.length-1);
    }
}