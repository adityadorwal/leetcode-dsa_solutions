class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n=nums.size();
        int result=Integer.MAX_VALUE;
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++) arr[i+1] = arr[i]+nums.get(i);
        while(l<=r)
        {
            for(int i=l;i<=n;i++)
            {
                int s = arr[i]-arr[i-l];
                if(s>0) result = Math.min(result,s);
            }
            l++;
        }
        if(result == Integer.MAX_VALUE)return -1;
        return result;
    }
}