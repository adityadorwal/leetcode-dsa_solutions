class Solution {
    public int climbStairs(int n) {
        if(n<=3)return n;
        int a=2,b=3,i;
        for(i=4;i<n;i++)
        {
            b=a+b;
            a=b-a;
        }
        return (a+b);
    }
}