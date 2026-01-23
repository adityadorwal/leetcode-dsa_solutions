class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro=1,i,n=nums.length;
        int []result = new int[n];
        for(i=0;i<n;i++)
        {
            result[i] =pro;
            pro*=nums[i];
        }
        pro=1;
        for(i=n-1;i>=0;i--)
        {
            result[i] *=pro;
            pro*=nums[i];
        }
        return(result);
    }
}