class Solution {
    public int longestOnes(int[] nums, int k) {
        int left =0, right =0,sum=0,max_one=0;
        while(left<=right && right<nums.length)
        {
            sum++;
            if(nums[right++]==0)k--;
            if(k==-1)
            {
                while(nums[left++]!=0)sum--;
                sum--;
                k++;
            }
            max_one = Math.max(max_one,sum);

        }
        return max_one;
    }
}