class Solution {
    public int maxArea(int[] height) {
        int left=0,right =height.length-1,max;
        max = 0;
        while(left<right)
        {
            int pro = Math.min(height[left],height[right]) * (right-left);
            max = Math.max(max,pro);
            if(height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
}