class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int num1=0 , num2=0 , c=0;
        for(int i=0;i<nums.size()-k;i++)
        {
            int a = nums.get(i);
            int b = nums.get(i+k);
            if(c==0 || (a>num1 && b>num2))
            {
                c++;
                if(c==k)return true;
            }
            else c=1;

            num1 = a;
            num2 = b;
        }
        return false;
    }
}