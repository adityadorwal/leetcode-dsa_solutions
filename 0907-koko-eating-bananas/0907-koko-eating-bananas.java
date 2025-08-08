class Solution {

    public boolean check(int[] piles, int h, int speed) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + speed - 1) / speed;  // ceiling division
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;

        // Initialize right to the maximum pile value
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        int result = -1;

        // Binary search for the minimum valid speed
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (check(piles, h, mid)) {
                result = mid;      // valid speed found, try smaller
                right = mid - 1;
            } else {
                left = mid + 1;    // too slow, try faster
            }
        }

        return result;
    }
}
