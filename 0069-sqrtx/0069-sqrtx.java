// class Solution {
//     public int mySqrt(int x) {
//         if(x<2)return x;
//         long i=0,end = x/2;
//         while(i<=end)
//         {
//             long mid = (i+end)/2;
//             if(mid*mid == x)return (int)mid;
//             else if(mid*mid < x)i=mid+1;
//             else end=mid-1;
//         }
//         return (int)i-1;
//     }
// }

//*************************************By Newton law************************* */


class Solution {
    public int mySqrt(int x) {
        if (x < 2) return x;

        long guess = x;
        while (guess * guess > x)guess = (guess + x / guess) / 2;
        return (int) guess;
    }
}
