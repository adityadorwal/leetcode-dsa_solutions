class Solution {
    public String reverseWords(String s) {
        s=" "+s+" ";
        int len =  s.length()-1;
        int prev = -1;
        boolean word = false;
        StringBuilder str = new StringBuilder();

        for(int i=len;i>=0;i--)
        {
            char ch = s.charAt(i);
            if(ch == ' ')
            {
                if(word)
                {
                    str.append(s.substring(i+1,prev));
                    str.append(" ");
                }
                prev = i;
                word=false;
            }
            else word = true;

        }
        return str.toString().substring(0,str.length()-1);
    }
}