/*****************************HASHSET Solution for this problem********************* */

// class Solution {
//     public boolean isHappy(int n) {
//         HashSet<Integer> num = new HashSet<>();
//         num.add(n);
//         while(n!=1)
//         {
//             int sum=0;
//             while(n>0)
//             {
//                 int rem = n%10;
//                 sum+=rem*rem; 
//                 n=n/10;
//             }
//             n=sum;
//             if(num.contains(n))return false;
//             num.add(n);
//         }
//         return true;
//     }
// }


/******************************************TWO Pointers approch ****************** */

class Solution {
    public int square_digit(int n)
    {
        int sum=0;
        while(n>0)
        {
            int rem = n%10;
            sum+=rem*rem;
            n=n/10;
        }
        return (sum);
    }
    public boolean isHappy(int n) {
        int slow = n,fast = n;
        while(true)
        {
            slow = square_digit(slow);
            fast = square_digit(square_digit(fast));
            if(slow == 1 && fast == 1)return true;
            if(slow == fast)return false;
        }
    }
}