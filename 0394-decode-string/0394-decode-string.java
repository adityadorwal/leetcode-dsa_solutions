class Solution {
    Stack <Character> stk = new Stack<>();
    Stack <String> sub = new Stack<>();

    public String iter(String s, int n)
    {
        if (n==1)return s;
        return (s+iter(s,n-1));
    }
    int start=0;

    public String decodeString(String s) {
        int l=s.length();
        String str="",num="",result="";
        while(start<l)
        {
            if(s.charAt(start)=='[')
            {
                start++;
                // if(num=="")num="1";
                result = result + iter(decodeString(s),Integer.parseInt(num));
                num="";
            }
            else if(Character.isDigit(s.charAt(start)))
            num = num+s.charAt(start);
            else if(s.charAt(start)==']')
            return(result);
            else
            result+=s.charAt(start);

            start++;
        }
        return result;
    }
}