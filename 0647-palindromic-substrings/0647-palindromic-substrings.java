class Solution {
    private int palindrome(String s,int start,int end)
    {
        int count=0;
        while(start>=0 && end <s.length() && s.charAt(start--)==s.charAt(end++))count++;
        return(count);
    }
    public int countSubstrings(String s) {
        int len=s.length(),count=0;
        for(int i=0;i<len;i++)
        {
            count+=palindrome(s,i,i);
            count+=palindrome(s,i,i+1);
        }
        return count;
    }
}