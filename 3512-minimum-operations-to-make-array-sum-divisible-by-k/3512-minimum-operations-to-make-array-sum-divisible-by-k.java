class Solution {
    public int minOperations(int[] nums, int k) {
        int n=0;
        for(int i:nums)n = (n+i)%k;
        return n;
    }
}