class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int rem=0,sum=0;
        while(numBottles>0)
        {
            sum += numBottles;
            int total_empty = numBottles+rem;
            numBottles = total_empty/numExchange;
            rem = total_empty%numExchange;
        }
        return sum;
    }
}