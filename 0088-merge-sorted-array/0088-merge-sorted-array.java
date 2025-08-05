class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m=m-1;
        n=n-1;
        for(int i=m+n+1 ; i>=0 ; i--)
        {
            if(m>-1 && n>-1)
            {
                if(nums1[m] >= nums2[n])nums1[i]=nums1[m--];
                else nums1[i]=nums2[n--];
            }
            else if(m>-1)nums1[i]=nums1[m--];
            else nums1[i] = nums2[n--];
        }
    }
}