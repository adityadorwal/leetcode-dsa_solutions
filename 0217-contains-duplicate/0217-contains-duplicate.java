class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            if(!map.add(nums[i]))
            return(true);
        }
        return(false);
    }
}