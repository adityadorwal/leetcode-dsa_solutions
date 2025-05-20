class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1;
        int maxleft=0,maxright=0,waterTrapped=0;

        while(left<right)
        {
            if(height[left]<height[right])
            {
                if(height[left]>=maxleft) maxleft=height[left];
                else waterTrapped += maxleft - height[left];
                left++;
            }
            else
            {
                if(height[right]>=maxright) maxright=height[right];
                else waterTrapped +=maxright-height[right];
                right--;
            }
        }
        return(waterTrapped);
    }
}