class Solution {
    public String convert(String s, int numRows) {
        int n = numRows*2-2,l=s.length(),k=0;
        if (n==0)return s;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<numRows;i++)
        {
            int c = i;
            while(c<l)
            {
                str.append(s.charAt(c));
                c+=n;
                if(i>0 && i<numRows-1 && c-k<l)
                {
                    str.append(s.charAt(c-k));
                }
                System.out.println(str);
            }
            k+=2;
        }
        return str.toString();
    }
}