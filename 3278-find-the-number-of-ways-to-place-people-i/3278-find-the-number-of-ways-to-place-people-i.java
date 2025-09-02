class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt((int[] p) -> p[0])
            .thenComparingInt(p -> -p[1]));

        int ans = 0, n = points.length;
        final int INF = 1 << 30;
        for (int i = 0; i < n; ++i) {
            int y1 = points[i][1];
            int maxY = -INF;
            for (int j = i + 1; j < n; ++j) {
                int y2 = points[j][1];
                if (maxY < y2 && y2 <= y1) {
                    ans++;
                    maxY = y2;
                }
            }
        }
        return ans;
    }
}