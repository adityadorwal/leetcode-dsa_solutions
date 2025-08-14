class Solution {
    public String largestGoodInteger(String num) {
        char a , b=num.charAt(0) ,c=num.charAt(1),s=' ';
        int z=-1;
        for(int i=2;i<num.length();i++)
        {
            a=b;
            b=c;
            c=num.charAt(i);
            if(a==b && b==c && s<a)
            {
                s=a;
                z=i-2;
                if(s=='9')return (num.substring(z,z+3));
            }
        }
        if(z==-1)return"";
        return (num.substring(z,z+3));
    }
}