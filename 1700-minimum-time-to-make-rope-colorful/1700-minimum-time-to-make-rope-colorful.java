class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        int ans = 0;
        int maxTime = neededTime[0];

        for (int i = 1; i < n; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                // conflict: remove the cheaper between maxTime and neededTime[i]
                ans += Math.min(maxTime, neededTime[i]);
                // keep the one with larger cost for future comparison
                maxTime = Math.max(maxTime, neededTime[i]);
            } else {
                // new color block
                maxTime = neededTime[i];
            }
        }

        return ans;
    }
}
