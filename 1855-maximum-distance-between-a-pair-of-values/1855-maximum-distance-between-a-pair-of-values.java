class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i = 0;
        int result = 0;
        int m = nums1.length, n = nums2.length;
        for (int j = 0; j < n; j++) {
            if (i < m && nums1[i] <= nums2[j])
                result = Math.max(result, j - i);
            else
                while (i < m && i <= j && nums1[i] > nums2[j])
                    i++;
        }
        return result;
    }
}