//Fastest Ever via inbuilt hardware System
// class Solution {
//     public int hammingWeight(int n) {
//         return(Integer.bitCount(n));
//     }
// }

//LIttle slow but calculation based function via recurssion
class Solution {
    public int hammingWeight(int n) {
        if(n==0)return 0;
        return (hammingWeight(n & (n-1)) + 1);
    }
}
