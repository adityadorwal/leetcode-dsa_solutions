class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full_bottle = numBottles, empty=0,drunk=0;
        while(full_bottle>0 || empty>=numExchange)
        {
            while(empty>=numExchange)
            {
                full_bottle++;
                empty -= numExchange;
                numExchange++;
            }
                drunk += full_bottle;
                empty += full_bottle;
                full_bottle =0;
        }
        return drunk;
    }
}