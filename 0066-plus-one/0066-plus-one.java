class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        int result[] = new int[n + 1];
        while (n > 0) {
            n--;
            int num = digits[n];
            num++;
            digits[n] = num%10;
            result[n + 1] = num%10;
            if (num / 10 == 0)
                return digits;
            carry = 1;
        }
        if (carry == 1)
            result[0] = 1;
        return result;

    }
}