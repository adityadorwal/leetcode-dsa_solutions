class Solution {
    public int maxOperations(String s) {
        int ans = 0;
        int onesCount = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesCount++;
            } else {
                // current is '0'
                if (i == n - 1 || s.charAt(i + 1) == '1') {
                    ans += onesCount;
                }
            }
        }
        return ans;
    }
}