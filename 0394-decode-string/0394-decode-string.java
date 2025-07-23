class Solution {
    int start=0;
    public String decodeString(String s) {
        int l=s.length();
        String str="",num="",result="";
        while(start<l)
        {
            if(s.charAt(start)=='[')
            {
                start++;
                result = result + (decodeString(s)).repeat(Integer.parseInt(num));
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