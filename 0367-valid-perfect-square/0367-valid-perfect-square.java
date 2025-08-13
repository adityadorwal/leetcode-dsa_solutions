//****************************************slow but working way************************** 
// class Solution {
//     public boolean isPerfectSquare(int num) {
//         int odd = 1;
//         while(num>0)
//         {
//             num -= odd;
//             odd += 2;
//         }
//         return (num == 0);
//     }
// }


//************************Binary search way*********************** */
class Solution {
    public boolean isPerfectSquare(int num) {
        long left =0,right=num;
        while(left <= right)
        {
            long mid = (left+right)/2;
            if(mid*mid == num)return true;
            else if(mid*mid < num)left = mid+1;
            else right = mid-1;
        }
        return false;
    }
}