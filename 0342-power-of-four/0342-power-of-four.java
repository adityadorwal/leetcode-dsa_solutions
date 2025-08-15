class Solution {
    public boolean isPowerOfFour(int n) {
        if(((n-1)&n) != 0 || n<=0)return false;
        return(Integer.numberOfTrailingZeros(n)%2 == 0);
        // double  num = n;
        // return((Math.log(num)/Math.log(4))%1.0 == 0.0);
    }
}