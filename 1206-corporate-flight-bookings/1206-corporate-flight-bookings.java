class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int arr[] = new int [n];
        for(int []i : bookings)
        {
            int start = i[0]-1;
            int end = i[1];
            int seat = i[2];
            while(start<end) arr[start++] += seat;
        }
        return arr;
    }
}