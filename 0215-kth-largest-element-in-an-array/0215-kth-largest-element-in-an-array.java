/*******************************Normal Sorted array way************************************ */
class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }
}

/*****************************Solving via Queue********************************** */
// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//         for(int i:nums)
//         {
//             if(k<=0)
//             {
//                 if(minHeap.peek()<i)
//                 {
//                     minHeap.poll();
//                     minHeap.offer(i);
//                 }
//             }
//             else
//             {
//                 minHeap.offer(i);
//                 k--;
//             }
//         }
//         return minHeap.peek();
//     }
// }