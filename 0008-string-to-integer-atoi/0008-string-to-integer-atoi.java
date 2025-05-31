class Solution {
    public int myAtoi(String s) {
        char [] ch = s.toCharArray();
        int i=0,k=1,sum=0,n=s.length();
        while(i<n && ch[i]==' ')i++;
        if (i < n && ch[i] == '-') {
            k = -1;
            i++;
        } else if (i < n && ch[i] == '+')i++;
        while(i<n && Character.isDigit(ch[i]))
        {
            int digit = ch[i++] - '0';
            if (sum > (Integer.MAX_VALUE - digit) / 10)
            return (k == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE);
            sum=sum*10+digit;
        }
        return(k*sum);
    }
}