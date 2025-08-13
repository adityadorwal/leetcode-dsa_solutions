class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        int left = 0, right = n - 1;
        int negCount = 0;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) left = mid + 1;
            else right = mid - 1;
        }
        negCount = left;

        left = 0; 
        right = n - 1;
        int posCount = 0;
        while (left <= right)
        {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= 0) left = mid + 1;
            else right = mid - 1;
        }
        posCount = n - left;

        return Math.max(negCount, posCount);
    }
}
