class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0, j = 0, row_len = mat.length, col_len = mat[0].length;
        int result[] = new int[row_len * col_len];
        for (int ind = 0; ind < row_len * col_len; ind++) {
            result[ind] = mat[i][j];
            if ((i + j) % 2 == 0) {
                if (j == col_len - 1)
                    i++;
                else if (i == 0)
                    j++;
                else {
                    i--;
                    j++;
                }
            } else {
                if (i == row_len - 1)
                    j++;
                else if (j == 0)
                    i++;
                else {
                    i++;
                    j--;
                }
            }
        }
        return result;
    }
}