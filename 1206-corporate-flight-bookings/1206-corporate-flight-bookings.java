// ******************** Brute Force Attack *********************
// class Solution {
//     public int[] corpFlightBookings(int[][] bookings, int n) {
//         int arr[] = new int [n];
//         for(int []i : bookings)
//         {
//             int start = i[0]-1;
//             int end = i[1];
//             int seat = i[2];
//             while(start<end) arr[start++] += seat;
//         }
//         return arr;
//     }
// }

//*********************************Naive Algorithm *************************** */

class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int arr[] =  new int[n];
        for(int i[] : bookings)
        {
            arr[i[0]-1] += i[2];
            if(i[1]<n) arr[i[1]] -= i[2];

            // for(int j:arr)System.out.print(j + " ");
            System.out.println();
        }
        for(int i=1;i<n;i++)
        {
            arr[i] = arr[i]+arr[i-1];
        }
        return arr;
    }
}