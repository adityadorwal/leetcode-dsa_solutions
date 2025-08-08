//*******************************Normal easy peasy runable solution********************************** 
// class Solution {
//     public int firstMissingPositive(int[] nums) {
//         HashSet<Integer> set = new HashSet<>();
//         for(int i:nums)if(i>0)set.add(i);
//         for(int i=1;i<=Integer.MAX_VALUE;i++)if(!set.contains(i))return i;
//         return 1;
//     }
// }


// ************** Modern Cyclic sorting solution ******************************************

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++)
        {
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) 
            {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) 
        {
            if (nums[i] != i + 1)return i + 1;
        }

        return n + 1;
    }
}

