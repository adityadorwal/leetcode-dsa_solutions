class Solution {
    public boolean check(int []weights , int days , int cap)
    {
        long sum = 0;
        for(int i : weights)
        {
            if(i>cap)return false;
            sum += i;
            if(sum>cap)
            {
                sum=i;
                days--;
            }
        }
        return days>0;
    }
    public int shipWithinDays(int[] weights, int days) {
        int left=0,right=Integer.MAX_VALUE,min=0;
        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(check(weights,days,mid))
            {
                min = mid;
                right = mid-1;
            }
            else left = mid+1;
        }
        return min;
    }
}