class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0,1);
        int prefix=0,count=0;
        for(int num : nums)
        {
            prefix+=num;
            if(map.containsKey(prefix-k))
                count+=map.get(prefix-k);
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return(count);
    }
}