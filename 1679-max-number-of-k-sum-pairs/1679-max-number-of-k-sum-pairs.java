class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int result=0;
        for(int num:nums)
        {
            if(num>k)continue;
            if(map.containsKey(num))
            {
                int temp = map.get(num);
                if(temp>1)map.put(num,temp-1);
                else map.remove(num);
                result++;
            }
            else
            {
                int diff = k-num;
                map.put(diff , map.getOrDefault(diff,0)+1);
            }
        }
        return result;
    }
}