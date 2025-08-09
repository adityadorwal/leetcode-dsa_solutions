class Solution {
    public void sortColors(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;

        while (mid <= right) {
            if (nums[mid] == 0) {
                // Swap nums[mid] and nums[left]
                int temp = nums[mid];
                nums[mid] = nums[left];
                nums[left] = temp;

                left++;
                mid++;
            } 
            else if (nums[mid] == 2) {
                // Swap nums[mid] and nums[right]
                int temp = nums[mid];
                nums[mid] = nums[right];
                nums[right] = temp;

                right--; // Don't increment mid here!
            } 
            else {
                mid++;
            }
        }
    }
}
