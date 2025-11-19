class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int arr[] = new int[101];
        for(int i:nums)
        {
            arr[i]++;
        }
        for(int i=1;i<101;i++)
        {
            arr[i] += arr[i-1];
        }
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            if(num != 0)nums[i] = arr[num-1];
        }
        return nums;
    }
}