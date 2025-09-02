class Solution {
    public int minDeletionSize(String[] strs) {
        int c=0;
        for(int i=0;i<strs[0].length();i++)
        {
            int p=0;
            for(String str:strs)
            {
                char ch = str.charAt(i);
                if(ch<p){p=-1;break;}
                p=ch;
            }
            if(p==-1)c++;
        }
        return c;
    }
}