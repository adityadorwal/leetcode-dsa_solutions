class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int max_sum=0;
        for(int i=0 ; i<k ; i++)max_sum+=nums[i];
        int sum = max_sum;
        for(int i=k ; i<nums.length ; i++)
        {
            sum = sum+nums[i]-nums[i-k];
            max_sum = Math.max(max_sum,sum);
        }
        return ((double)max_sum/k);
    }
}