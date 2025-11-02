class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];  // 0 = empty, -1 = wall, -2 = guard
        for (int[] w : walls) grid[w[0]][w[1]] = -1;
        for (int[] g : guards) grid[g[0]][g[1]] = -2;

        // Mark visibility row-wise (left→right, right→left)
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) seen = false;
                else if (grid[i][j] == -2) seen = true;
                else if (seen) grid[i][j] = 1;
            }
            seen = false;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == -1) seen = false;
                else if (grid[i][j] == -2) seen = true;
                else if (seen) grid[i][j] = 1;
            }
        }

        // Mark visibility column-wise (top→bottom, bottom→top)
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == -1) seen = false;
                else if (grid[i][j] == -2) seen = true;
                else if (seen) grid[i][j] = 1;
            }
            seen = false;
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == -1) seen = false;
                else if (grid[i][j] == -2) seen = true;
                else if (seen) grid[i][j] = 1;
            }
        }

        // Count unguarded cells
        int count = 0;
        for (int[] row : grid)
            for (int cell : row)
                if (cell == 0) count++;

        return count;
    }
}
