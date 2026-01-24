class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int max_result =-1;
        for(int right=0; right<nums.length ;right++)
        {
            
            if(nums[right] == 0)k--;
            while(k == -1)
            {
                if(nums[left++]==0)k++;
            }
            int diff = right-left;
            if(max_result < diff)max_result = diff;
        }
        return max_result+1;
    }
}