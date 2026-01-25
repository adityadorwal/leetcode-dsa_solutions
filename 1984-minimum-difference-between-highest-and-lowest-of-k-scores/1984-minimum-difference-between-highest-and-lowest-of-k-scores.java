class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int min_diff = Integer.MAX_VALUE;
        for(int i=k-1;i<nums.length;i++)
        {
            int diff = nums[i]-nums[i-k+1];
            if(diff<min_diff)min_diff = diff;
        }
        return min_diff;
    }
}