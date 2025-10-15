class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int pre=0, count=0, max = 1, num=0;
        for(int i=0;i<nums.size();i++)
        {
            int a= nums.get(i);
            if(count == 0 || (a>num)) count++;

            else
            {
                max = Math.max(Math.max(max,Math.min(count,pre)),count/2);
                
                pre = count;
                count=1;
            }
            num = a;
        }
        max = Math.max(Math.max(max,Math.min(count,pre)),count/2);
        return max;
    }
}