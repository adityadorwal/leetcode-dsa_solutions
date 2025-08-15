class Solution {
    public boolean isPowerOfFour(int n) {
        double  num = n;
        return((Math.log(num)/Math.log(4))%1.0 == 0.0);
    }
}