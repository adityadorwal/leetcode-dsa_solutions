class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length,len2 = nums2.length;
        int median_pos = (len1+len2)/2;
        int k=-1,i=0,j=0;
        double num1=0,num2=0;
        while(i<len1 && j<len2 && k!=median_pos)
        {
            num1=num2;
            if(nums1[i]<=nums2[j])num2=nums1[i++];
            else num2 = nums2[j++];
            k++;
            System.out.println(k+"  "+num1+" "+num2);
        }
        while(i<len1 && k!=median_pos)
        {
            num1 = num2;
            num2 = nums1[i++];
            k++;
        }
        while(j<len2 && k!=median_pos)
        {
            num1 = num2;
            num2 = nums2[j++];
            k++;
        }
        
        if((len1+len2)%2==0)return ((num1+num2)/2);
        return num2;
    }
}