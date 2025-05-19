class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pro=1,i,n=nums.length;

        // Another approch
        //int pro1=1,pro2=1;
        // int []prefix = new int[n];
        // int []suffix = new int[n];
        // for(i=0;i<n;i++)
        // {
        //     prefix[i]=pro1;
        //     suffix[n-i-1]=pro2;
        //     pro1*=nums[i];
        //     pro2*=nums[n-i-1];
        // }
        // for(i=0;i<n;i++)
        // nums[i]=prefix[i]*suffix[i];
        // return(nums);

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