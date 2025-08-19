class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long subarray = 0,c=0;
        for(int i : nums)
        {
            c=(i==0)?c+1:0;
            subarray+=c;
        }
        return subarray;
    }
}