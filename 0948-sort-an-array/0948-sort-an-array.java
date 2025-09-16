/**************************************Using the same Array to return******************** */

// class Solution {
//     public void merge(int[] nums, int start, int mid, int end) {
//         int[] temp = new int[end - start + 1];
//         int i = start, j = mid + 1, k = 0;

//         while (i <= mid && j <= end) {
//             if (nums[i] <= nums[j]) {
//                 temp[k++] = nums[i++];
//             } else {
//                 temp[k++] = nums[j++];
//             }
//         }

//         while (i <= mid)
//             temp[k++] = nums[i++];
//         while (j <= end)
//             temp[k++] = nums[j++];

//         for (int x = 0; x < temp.length; x++) {
//             nums[start + x] = temp[x];
//         }
//     }

//     public void partition(int[] nums, int start, int end) {
//         if (start >= end)
//             return;
//         int mid = (start + end) / 2;
//         partition(nums, start, mid);
//         partition(nums, mid + 1, end);
//         merge(nums, start, mid, end);
//     }

//     public int[] sortArray(int[] nums) {
//         partition(nums, 0, nums.length - 1);
//         return nums;
//     }
// }

/*********************************Forming a new Array to store the result***************** */


class Solution {
    public void merge(int[] nums, int start, int mid, int end, int[] result) {
        int i = start, j = mid + 1, k = start;

        while (i <= mid && j <= end)
        {
            if (nums[i] <= nums[j]) result[k++] = nums[i++];
            else result[k++] = nums[j++];
        }
        while (i <= mid) result[k++] = nums[i++];
        while (j <= end) result[k++] = nums[j++];

        for(int z=start;z<=end;z++)
        {
            nums[z]=result[z];
        }
    }

    public void partition(int[] nums, int start, int end, int[] result) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        partition(nums, start, mid ,result);
        partition(nums, mid + 1, end, result);
        merge(nums, start, mid, end, result);
    }

    public int[] sortArray(int[] nums) {
        int result[] = new int[nums.length];
        partition(nums, 0, nums.length - 1,result);
        return result;
    }
}

