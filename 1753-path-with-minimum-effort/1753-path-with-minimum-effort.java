class Solution {
    int[][] direct = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int dist[][] = new int[m][n];

        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        que.offer(new int[] { 0, 0, 0 });

        while (!que.isEmpty()) {
            int arr[] = que.poll();
            int i = arr[0], j = arr[1], w = arr[2];
            if (dist[i][j] != w)
                continue;
            if (i == m - 1 && j == n - 1)
                return w;

            for (int[] k : direct) {
                int a = i + k[0], b = j + k[1];
                if (a >= 0 && b >= 0 && a < m && b < n) {
                    int newEffort = Math.max(w, Math.abs(heights[a][b] - heights[i][j]));
                    if (newEffort < dist[a][b]) {
                        dist[a][b] = newEffort;
                        que.offer(new int[] { a, b, newEffort });
                    }
                }
            }

        }
        return 0;
    }
}