class Solution {
    public int strStr(String haystack, String needle) {
        int m=haystack.length(),n=needle.length();
        for(int i=0;i<m;i++)
        {
            if(haystack.charAt(i)==needle.charAt(0) && i+n<=m && haystack.substring(i,i+n).equals(needle))
            return i;
        }
        return(-1);
    }
}