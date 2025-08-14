class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefix = 0 , count = 0;
        for(int i : nums)
        {
            prefix += i;
            if(map.containsKey(prefix-k))count+=map.get(prefix-k);
            map.put(prefix,map.getOrDefault(i-k,0)+1);
        }
        return count;
    }
}