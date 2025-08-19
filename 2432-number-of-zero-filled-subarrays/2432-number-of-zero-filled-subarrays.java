class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarray = 0;
        int c=0;
        for(int i=0 ; i<nums.length ; i++)
        {
            if(nums[i] != 0)
            c=0;
            else
            {
                c++;
                subarray+=c;
            }
        }
        return subarray;
    }
}