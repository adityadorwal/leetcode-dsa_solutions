class Solution {
    public int findPeakElement(int[] nums) {
        int i=1,l=nums.length;
        int z= l-1;
        if(l==1)return 0;
        l = l-2;
        while(i<=l)
        {
            if(nums[i-1]<nums[i])
            {
                if(nums[i]>nums[i+1])return i;
                i++;
            }
            else i+=2;
            if(nums[l-1]<nums[l])
            {
                if(nums[l]>nums[l+1])return l;
                l--;
            }
            else l-=1;
        }
        if(nums[0]>nums[1])return 0;
        return z;
    }
}