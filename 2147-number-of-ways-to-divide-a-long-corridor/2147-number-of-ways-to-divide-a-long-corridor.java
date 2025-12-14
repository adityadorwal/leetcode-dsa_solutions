class Solution {
    public int numberOfWays(String corridor) {
        long result = 1;
        int seat=0;
        int len = corridor.length();
        int i=0;
        while(i<len)
        {
            char ch = corridor.charAt(i++);
            if( ch == 'S')seat++;
            if(seat >0 && seat%2 == 0)
            {
                int gap = 1;
                while(i<len && corridor.charAt(i) != 'S')
                {
                    gap++;
                    i++;
                }
                if(i<len)result = (result*gap)%1000000007;
            }
        }
        if(seat==0 || seat%2!=0)return 0;
        return (int)result;
    }
}