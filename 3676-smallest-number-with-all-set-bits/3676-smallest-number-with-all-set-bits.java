class Solution {
    public int smallestNumber(int n) {
        return (int)Math.pow(2,Math.floor(Math.log(n)/Math.log(2))+1)-1;
    }
}