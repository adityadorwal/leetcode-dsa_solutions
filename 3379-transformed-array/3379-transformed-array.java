class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n=nums.length;
        int result[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int curr = nums[i];
            int k=i;
            if(curr>0)
            {
                int steps = Math.abs(curr)%n;
                k = (k+steps)%n;
                result[i] = nums[k];
            }
            else if(curr<0)
            {
                int steps = Math.abs(curr)%n;
                k = (k-steps+n)%n;
                result[i] = nums[k];
            }
            else result[i] = nums[k];
        }
        return result;
    }
}