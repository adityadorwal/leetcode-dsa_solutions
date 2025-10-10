class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int result[] = new int[k];
        int n = energy.length;
        int max_result=Integer.MIN_VALUE;
        for(int i=0;i<k;i++)
        {
            int sum=0;
            for(int j=i;j<n;j+=k)
            {
                int num = energy[j];
                if(num+sum < num)sum=0;
                sum += num;
            }
            max_result = Math.max(max_result,sum);
        }
        return max_result;
    }
}