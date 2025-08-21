class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] height = new int[m];
        int total = 0;

        for (int i = 0; i < n; i++) {
            // Step 1: build histogram heights
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            // Step 2: count submatrices ending at row i
            for (int j = 0; j < m; j++) {
                if (height[j] > 0) {
                    int minH = height[j];
                    for (int k = j; k >= 0; k--) {
                        minH = Math.min(minH, height[k]);
                        if (minH == 0) break;
                        total += minH;
                    }
                }
            }
        }

        return total;
    }
}
