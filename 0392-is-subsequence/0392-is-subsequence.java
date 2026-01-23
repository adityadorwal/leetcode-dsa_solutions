class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length() , len2 = t.length();
        if(len1 == 0)return true;
        if(len1>len2)return false;
        int k=0;
        char ch = s.charAt(k);
        for(int i=0;i<len2;i++)
        {
            if(ch == t.charAt(i))
            {
                k++;
                if(k==len1)return true;
                ch = s.charAt(k);
            }
        }
        return false;
    }
}