class Solution {
    public long factorial(int num)
    {
        long fact=1;
        while(num>1)
        {
            fact += num;
            num--;
        }
        return fact;
    }
    public long getDescentPeriods(int[] prices) {
        long result = 0;
        int con =1;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i-1]-prices[i] != 1)
            {
                result += factorial(con);
                con =1;
            }
            else
            {
                con++;
            }
        }
        result += factorial(con);
        return result;
    }
}