class Solution {
    public int maximum69Number (int num) {
        int x =num,c=0,d=-1;
        while(x>0)
        {
            if(x%10 == 6)d=c;
            x=x/10;
            c++;
        }
        if(d==-1)return num;
        System.out.println(d);

        d=(int)Math.pow(10,d);
        x = num%d;
        num = num/d + 3;
        num = (num*d) + x;

        return num;
    }
}