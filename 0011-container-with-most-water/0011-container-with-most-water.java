class Solution {
    public int maxArea(int[] height) {
        int p=0,q=height.length-1,max=0;
        while(p<q)
        {
            max=Math.max(max,(Math.min(height[p],height[q])*(q-p)));
            if(height[p]<height[q])p++;
            else q--;
        }
        return(max);
    }
}