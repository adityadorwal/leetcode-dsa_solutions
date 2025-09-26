// class Solution {
//     Integer[][] memo;
//     public int divarray(int []nums,int k,int curr,int size)
//     {
//         if(k==1)
//         {
//             int add=0;
//             for(int i=curr;i<size;i++) add+=nums[i];
//             return add;
//         }
//         if(memo[curr][k] != null)return memo[curr][k];
//         int sum = 0;
//         int result = Integer.MAX_VALUE;
//         for (int i = curr; i <= size - k; i++)
//         {
//             sum += nums[i];
//             int next = divarray(nums, k - 1, i + 1, size);
//             result = Math.min(result, Math.max(sum, next));
//         }
//         memo[curr][k]=result;
//         return result; 
//     }
//     public int splitArray(int[] nums, int k) {
//         memo = new Integer[nums.length][k+1];
//         return divarray(nums,k,0,nums.length);
//     }
// }

class Solution {
    
    public  boolean canSplit(int[] nums, int k, int maxSum)
    {
        int count = 1, currSum = 0;
        for (int num : nums)
        {
            if (currSum + num > maxSum)
            {
                count++;
                currSum = num; // start new subarray
            }
            else currSum += num;
        }
        return count <= k;
    }
    public int splitArray(int[] nums, int k) {
        int max = 0, sum = 0;
        for (int num : nums)
        {
            max = Math.max(max, num);
            sum += num;
        }

        int left = max, right = sum;

        while (left < right)
        {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) right = mid; // try smaller max sum
            else left = mid + 1; // need larger max sum
        }
        return left;
    }
}
