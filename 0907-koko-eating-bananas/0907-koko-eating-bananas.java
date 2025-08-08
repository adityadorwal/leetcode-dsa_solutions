class Solution {
    public boolean check(int [] piles, int h,int min)
    {
        long c=0;
        for(int i: piles)
        {
            c += (i+min-1)/min;
        }
        return c<=h;
    }
    public int minEatingSpeed(int[] piles, int h) {

        int left =0,right=0;
        for(int i: piles)
        {
            left += i;
            if(right<i)right = i;
        }

        left = Math.max(left/h,1);
        int result=right;

        while(left<=right)
        {
            int mid = left + (right-left)/2;
            if(check(piles,h,mid))
            {
                result = mid;
                right = mid-1;
            }
            else
            left = mid+1;
        }
        
        return result;
    }
}