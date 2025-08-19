class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0, max=0,left=0;
        for(int i:nums)
        {
            sum += i;
            if(map.containsKey(i))
            {
                left=Math.max(left,map.get(i));
            }
            map.put(i,sum);
            max = Math.max(max,sum-left);
        }
        return max;
    }
}