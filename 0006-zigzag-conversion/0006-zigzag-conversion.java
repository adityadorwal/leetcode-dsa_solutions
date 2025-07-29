class Solution {
    public String convert(String s, int numRows) {
        int n = numRows*2-2,l=s.length(),k=0;
        if (n==0)return s;
        String str="";
        for(int i=0;i<numRows;i++)
        {
            int c = i;
            while(c<l)
            {
                str+=s.charAt(c);
                c+=n;
                if(i>0 && i<numRows-1 && c-k<l)
                str+=s.charAt(c-k);
            }
            k+=2;
        }
        return str;
    }
}