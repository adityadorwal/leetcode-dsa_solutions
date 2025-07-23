class Solution {
    int start=0;
    public String decodeString(String s) {
        int l=s.length(),num=0;
        String result="";
        char ch;
        while(start<l)
        {
            ch = s.charAt(start);
            if(ch=='[')
            {
                start++;
                result = result + (decodeString(s)).repeat(num);
                num=0;
            }
            else if(Character.isDigit(ch))
            num = num*10+(ch-'0');
            else if(ch==']')
            return(result);
            else
            result+=ch;

            start++;
        }
        return result;
    }
}