class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int num = nums[i];
            if(i>k)
            {
                int freq = map.get(nums[i-k-1])-1;
                if(freq == 0) map.remove(nums[i-k-1]);
                else map.put(nums[i-k-1],freq);
            }
            if(map.containsKey(num))return true;
            map.put(num,map.getOrDefault(num,0)+1);
        }
        return false;
    }
}