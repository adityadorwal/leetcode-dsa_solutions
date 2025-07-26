// class Solution {
//     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//         int len1 = nums1.length,len2 = nums2.length;
//         int median_pos = (len1+len2)/2;
//         int k=-1,i=0,j=0;
//         double num1=0,num2=0;
//         while(i<len1 && j<len2 && k!=median_pos)
//         {
//             num1=num2;
//             if(nums1[i]<=nums2[j])num2=nums1[i++];
//             else num2 = nums2[j++];
//             k++;
//         }
//         while(i<len1 && k!=median_pos)
//         {
//             num1 = num2;
//             num2 = nums1[i++];
//             k++;
//         }
//         while(j<len2 && k!=median_pos)
//         {
//             num1 = num2;
//             num2 = nums2[j++];
//             k++;
//         }
        
//         if((len1+len2)%2==0)return ((num1+num2)/2);
//         return num2;
//     }
// }


class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            // Always binary search on the smaller array
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;
        int low = 0, high = x;

        while (low <= high) {
            int partitionX = (low + high) / 2;
            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
            int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((x + y) % 2 == 0) {
                    return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            } else {
                low = partitionX + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}
