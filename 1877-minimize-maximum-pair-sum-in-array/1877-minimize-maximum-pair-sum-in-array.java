class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int max_result = 0;
        int p=0,q=nums.length-1;
        while(p<q)
        {
            int sum = nums[p]+nums[q];
            if(sum > max_result)max_result = sum;
            p++;
            q--;
        }
        return max_result;
    }
}