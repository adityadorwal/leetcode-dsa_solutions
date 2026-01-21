class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
        {
            int a = nums.get(i);

            // lowest set bit of (a + 1)
            int lowest = (a + 1) & -(a + 1);

            // minimal x such that x | (x + 1) == a
            ans[i] = a - (lowest >> 1);
            if(a==2)ans[i]=-1;
        }
        return ans;
    }
}