class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int pre=0;
        int j=0;
        int z=0;
        for(int i:nums)
        {

            int diff = pre-i;
            if(z==0 || Math.abs(diff)>k)pre = i-k;
            else if(diff<k)pre = i+diff+1;
            else continue;
            z++;
        }
        return z;
    }
}