class Solution {
    public int maxFrequencyElements(int[] nums) {
        int []arr = new int[101];
        int max=0,sum=0;
        for(int i:nums) arr[i]++;
        for(int i:arr)
        {
            if(i>max)
            {
                max =i;
                sum = i;
            }
            else if(i==max)
            {
                sum+=max;
            }
        }
        return sum;
    }
}