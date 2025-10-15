class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pre=0, count=0, max = 1, num=0;
        for(int i=0;i<nums.size();i++)
        {
            int a= nums.get(i);
            if(count == 0 || (a>num)) count++;

            else
            {
                if(pre != 0)
                {
                    max = Math.max(max,Math.min(count,pre));
                }
                max = Math.max(max,count/2);
                
                pre = count;
                count=1;
            }
            num = a;
        }
        max = Math.max(count/2,Math.max(max,Math.min(count,pre)));
        return max;
    }
}