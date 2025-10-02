// class Solution {
//     String str;
//     int m, n;
//     int direct[][] = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

//     public boolean check(char[][] board, int i, int j, int curr) {
//         if (curr == str.length()) return true;

//         char temp = board[i][j];
//         board[i][j] = '*';                  // mark visited
//         char curr_ch = str.charAt(curr);    // char we need in neighbors

//         for (int[] arr : direct) {
//             int a = i + arr[0], b = j + arr[1];
//             if (a >= 0 && b >= 0 && a < m && b < n && board[a][b] == curr_ch) {
//                 if (check(board, a, b, curr + 1)) {
//                     board[i][j] = temp;   // restore before returning
//                     return true;         // early exit when found
//                 }
//             }
//         }

//         board[i][j] = temp; // backtrack
//         return false;
//     }

//     public boolean exist(char[][] board, String word) {
//         if (board == null || board.length == 0 || word == null) return false;
//         if (word.length() == 0) return true;

//         str = word;
//         m = board.length;
//         n = board[0].length;

//         char ch = word.charAt(0);
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (board[i][j] == ch && check(board, i, j, 1)) return true;
//             }
//         }
//         return false;
//     }
// }


class Solution {
    int m, n;
    String str;
    int[][] direct = {{-1,0},{1,0},{0,-1},{0,1}};

    // frequency pruning
    private boolean canForm(char[][] board, String word) {
        int[] freqBoard = new int[58]; // 'z' - 'A' ~ 58
        int[] freqWord = new int[58];
        for (char[] row : board) {
            for (char c : row) {
                freqBoard[c - 'A']++;
            }
        }
        for (char c : word.toCharArray()) {
            freqWord[c - 'A']++;
            if (freqWord[c - 'A'] > freqBoard[c - 'A']) return false;
        }
        return true;
    }

    public boolean dfs(char[][] board, int i, int j, int idx) {
        if (idx == str.length()) return true;
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] != str.charAt(idx)) return false;

        char temp = board[i][j];
        board[i][j] = '#'; // visited

        for (int[] d : direct) {
            if (dfs(board, i + d[0], j + d[1], idx + 1)) {
                board[i][j] = temp;
                return true;
            }
        }

        board[i][j] = temp; // backtrack
        return false;
    }

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        str = word;

        if (!canForm(board, word)) return false;

        // choose rarer end to start with
        if (countChar(board, word.charAt(0)) > countChar(board, word.charAt(word.length() - 1))) {
            str = new StringBuilder(word).reverse().toString();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, 0)) return true;
            }
        }
        return false;
    }

    private int countChar(char[][] board, char c) {
        int cnt = 0;
        for (char[] row : board) {
            for (char x : row) if (x == c) cnt++;
        }
        return cnt;
    }
}
