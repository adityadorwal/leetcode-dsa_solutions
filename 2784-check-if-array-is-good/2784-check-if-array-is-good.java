class Solution {
    public boolean isGood(int[] nums) {
        int n= nums.length-1;
        boolean result = false;
        int map[] = new int[n+2];
        for(int i:nums)
        {
            if(i>n)return false;
            if(map[i]==-1)
            {
                if(i==n && !result)result = true;
                else return false;
            }
            else map[i]=-1;
        }
        return true;
    }
}