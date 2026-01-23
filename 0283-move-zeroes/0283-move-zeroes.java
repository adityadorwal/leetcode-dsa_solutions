class Solution {
    public void moveZeroes(int[] nums) {
        int i,l=nums.length,k=0;
        for(i=0;i<l;i++)
        {
           if(nums[i]!=0)
           {
            nums[k++]=nums[i];
           }
        }
        for(i=k;i<l;i++)
        {
            nums[i]=0;
        }
    }
}