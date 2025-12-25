class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int n = happiness.length-1;
        long result = 0;
        int z=0;
        for(int i=n;i>n-k;i--)
        {
            int num = happiness[i]-z;
            result+=(num>0)?num:0;
            z++;
        }
        return result;
    }
}