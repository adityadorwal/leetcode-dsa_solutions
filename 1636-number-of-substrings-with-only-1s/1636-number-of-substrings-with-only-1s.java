class Solution {
    public int numSub(String s) {
        int c=1;
        long result=0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == '1')
            {
                result = (result+c)%1000000007;
                c++;
            }
            else
            {
                c=1;
            }
        }
        return (int)result;
    }
}