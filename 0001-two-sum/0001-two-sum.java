class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i,l=nums.length;
        for(i=0;i<l;i++)
        {
            if(map.containsKey(target-nums[i]) && map.get(target-nums[i])!=i)
            return(new int []{map.get(target-nums[i]),i});
            map.put(nums[i],i);
        }
        return(new int []{-1,-1});
    }
}