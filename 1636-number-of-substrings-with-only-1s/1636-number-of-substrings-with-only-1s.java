class Solution {
    public int numSub(String s) {
        long result = 0;
        long mod = 1000000007;
        int n = s.length();
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '1') {
                int start = i;
                while (i < n && s.charAt(i) == '1') i++;
                long len = i - start;
                result = (result + (len * (len + 1) / 2) % mod) % mod;
            } else {
                i++;
            }
        }
        return (int) result;
    }
}
