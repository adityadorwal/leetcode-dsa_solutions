class Solution {
    public int[] sortedSquares(int[] nums) {
        int left =0,right=nums.length-1,k,num1,num2;
        k=right;
        int [] result = new int [right+1];
        while(left<=right)
        {
            num1 = (int)Math.pow(nums[left],2);
            num2 = (int)Math.pow(nums[right],2);
            if(num1<num2)
            {
                result[k--] = num2;
                right--;
                continue;
            }
            result[k--] = num1;
            left++;
        }
        return result;
    }
}