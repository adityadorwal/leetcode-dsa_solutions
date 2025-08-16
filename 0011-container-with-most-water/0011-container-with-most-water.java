class Solution {
    public int maxArea(int[] height) {
        int left=0,right =height.length-1,max;
        max = Math.min(height[left],height[right]);
        while(left<right)
        {
            int pro = (int)Math.min(height[left],height[right]) * (right-left);
            max = Math.max(max,pro);
            if(height[left]<height[right])left++;
            else right--;
        }
        return max;
    }
}