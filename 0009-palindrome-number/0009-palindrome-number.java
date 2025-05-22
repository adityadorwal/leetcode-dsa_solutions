class Solution {
    public boolean isPalindrome(int x) {
        int n=x,r,s=0;
        while(n>0)
        {
            r=n%10;
            n=n/10;
            s=s*10+r;
        }        
        if(s==x)
        return true;
        return false;
    }
}