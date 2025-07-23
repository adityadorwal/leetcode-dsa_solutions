class Solution {
    int start=0;
    public String decodeString(String s) {
        int l=s.length();
        String num="",result="";
        char ch;
        while(start<l)
        {
            ch = s.charAt(start);
            if(ch=='[')
            {
                start++;
                result = result + (decodeString(s)).repeat(Integer.parseInt(num));
                num="";
            }
            else if(Character.isDigit(ch))//(ch >= '0' && ch <= '9')
            num = num+ch;
            else if(ch==']')
            return(result);
            else
            result+=ch;

            start++;
        }
        return result;
    }
}