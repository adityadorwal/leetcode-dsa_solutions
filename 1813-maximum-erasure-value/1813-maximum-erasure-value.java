/*******************************Solution using HashMap*********************************** */
// class Solution {
//     public int maximumUniqueSubarray(int[] nums) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         int sum=0, max=0,left=0;
//         for(int i:nums)
//         {
//             sum += i;
//             if(map.containsKey(i))left=Math.max(left,map.get(i));
//             map.put(i,sum);
//             max = Math.max(max,sum-left);
//         }
//         return max;
//     }
// }

/************************************Solution using HashSet********************************** */
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxresult=0 , currsum=0 , left=0;
        Set<Integer> set = new HashSet<>();
        for(int i:nums)
        {
            while(set.contains(i))
            {
                set.remove(nums[left]);
                currsum = currsum-nums[left];
                left++;
            }
            currsum = currsum+i;
            set.add(i);
            maxresult = Math.max(maxresult,currsum);
        }
        return maxresult;
    }
}