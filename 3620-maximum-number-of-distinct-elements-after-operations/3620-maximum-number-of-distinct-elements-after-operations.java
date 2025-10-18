// class Solution {
//     public int maxDistinctElements(int[] nums, int k) {
//         Arrays.sort(nums);
//         int pre=0;
//         int j=0;
//         int z=0;
//         for(int i:nums)
//         {

//             int diff = pre-i;
//             if(z==0 || Math.abs(diff)>k)pre = i-k;
//             else if(diff<k)pre = i+diff+1;
//             else continue;
//             z++;
//         }
//         return z;
//     }
// }

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        long prev = Long.MIN_VALUE; // track last chosen distinct number

        for (int num : nums) {
            long left = num - k;
            long right = num + k;

            // We must pick something > prev and <= right
            long pick = Math.max(prev + 1, left);
            if (pick <= right) {
                count++;
                prev = pick;
            }
        }
        return count;
    }
}
