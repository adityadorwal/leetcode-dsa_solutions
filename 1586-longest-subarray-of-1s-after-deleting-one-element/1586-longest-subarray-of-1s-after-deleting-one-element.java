/************************Array Fast Solution **************************** */

// class Solution {
//     public int longestSubarray(int[] nums) {
//         int left = 0, max_size = 0, k = 0;
//         int arr[] = new int[2];
//         for (int right = 0; right < nums.length; right++) {
//             if (nums[right] == 0)
//                 arr[k++] = right;
//             if (k > 1) {
//                 left = arr[0] + 1;
//                 arr[0] = arr[1];
//                 k--;
//             }
//             max_size = Math.max(max_size, right - left);
//         }
//         return max_size;
//     }
// }

/********************Stack Slow Solution********************** */
// class Solution {
//     public int longestSubarray(int[] nums) {
//         Queue<Integer> que = new LinkedList<>();
//         int max_len = 0, k = 0, left = 0;
//         for (int i = 0; i < nums.length; i++) {
//             if (nums[i] == 0) {
//                 que.offer(i);
//                 k++;
//             }
//             if (k > 1) {
//                 k--;
//                 left = que.poll() + 1;
//             }
//             max_len = Math.max(max_len, i - left);
//         }
//         return max_len;
//     }
// }

/*************************Two Pointers Approch ******************* */
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, zeros = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0)
                zeros++;

            while (zeros > 1) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }
            res = Math.max(res, right - left);
        }
        return res;
    }
}