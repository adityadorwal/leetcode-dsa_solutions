class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        String result="";
        for(int i=0;i<s.length()*2;i++)
        {
            int left=i/2;
            int right=(i%2==0)?left:left+1;
            int count=0;
            while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right))
            {
                count=right-left+1;
                left--;
                right++;
            }
            if(max<count)
            {
                max=count;
                result=s.substring(left+1,right);
            }
        }
        return(result);
    }
}