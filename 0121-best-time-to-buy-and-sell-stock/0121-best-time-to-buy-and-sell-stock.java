class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0],i,profit=0;
        for(i=0;i<prices.length;i++)
        {
            min=Math.min(prices[i],min);
            profit=Math.max(profit,prices[i]-min);
        }
        return(profit);
    }
}