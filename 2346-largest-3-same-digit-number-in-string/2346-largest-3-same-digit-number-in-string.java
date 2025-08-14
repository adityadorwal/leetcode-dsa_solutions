class Solution {
    public String largestGoodInteger(String num) {
        char a , b=num.charAt(0) ,c=num.charAt(1),s=' ';
        for(int i=2;i<num.length();i++)
        {
            a=b;
            b=c;
            c=num.charAt(i);
            if(a==b && b==c && s<a)
            {
                s=a;
                if(s=='9')return(""+s+s+s);
            }
        }
        return ((s==' ')?"":""+s+s+s);
    }
}