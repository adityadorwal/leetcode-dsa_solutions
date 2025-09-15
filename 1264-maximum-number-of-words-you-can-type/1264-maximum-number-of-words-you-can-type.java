class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int mask=0;
        for(int i=0;i<brokenLetters.length();i++)
        {
            mask |= 1<<(brokenLetters.charAt(i)-97);
        }
        int k=0,count=0;
        for(int i=0;i<text.length();i++)
        {
            char ch = text.charAt(i);
            if ((mask & (1<<(ch-'a'))) != 0)k = 1;
            if(ch == ' ')
            {
                if(k==0)count++;
                k=0;
            }
        }
        return (k==0)?count+1:count;
    }
}