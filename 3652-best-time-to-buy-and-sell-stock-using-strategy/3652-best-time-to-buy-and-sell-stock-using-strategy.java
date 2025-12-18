class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        long max_result=0;
        long sum=0;
        int half = k/2;
        for(int i=0;i<strategy.length;i++)
        {
            int num = prices[i];
            int mul = strategy[i];
            if(i<half)sum+=num*0;
            else if(i<k)sum+=num*1;
            else sum += num*mul;
            max_result += num*mul;
        }
        max_result = Math.max(max_result,sum);
        for(int i=k;i<strategy.length;i++)
        {
            sum = sum - (prices[i]*strategy[i]);
            sum = sum + prices[i];

            sum = sum - (prices[i-(half)]);

            sum = sum + (prices[i-k]*strategy[i-k]);

            max_result = Math.max(max_result,sum);
        }
        return max_result;
    }
}