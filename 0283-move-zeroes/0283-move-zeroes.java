class Solution {
    public void moveZeroes(int[] nums) {
        int l=nums.length,k=0;
        for(int i=0;i<l;i++)
        {
           if(nums[i]!=0)
           nums[k++]=nums[i];
        }
        for(int i=k;i<l;i++)
        nums[i]=0;
    }
}