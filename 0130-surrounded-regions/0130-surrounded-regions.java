class Solution {
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    
    public void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            board[i][j] != 'O' || visited[i][j]) return;
        
        visited[i][j] = true;
        board[i][j] = '#'; // mark as safe

        for (int[] d : dirs) {
            dfs(board, visited, i + d[0], j + d[1]);
        }
    }

    public void solve(char[][] board) {
        int r = board.length, c = board[0].length;
        boolean[][] visited = new boolean[r][c];
        
        // Step 1: Mark border-connected 'O'
        for (int i = 0; i < r; i++) {
            if (board[i][0] == 'O') dfs(board, visited, i, 0);
            if (board[i][c - 1] == 'O') dfs(board, visited, i, c - 1);
        }
        for (int j = 0; j < c; j++) {
            if (board[0][j] == 'O') dfs(board, visited, 0, j);
            if (board[r - 1][j] == 'O') dfs(board, visited, r - 1, j);
        }

        // Step 2: Flip remaining 'O' → 'X', and '#' → 'O'
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == '#') board[i][j] = 'O';
            }
        }
    }
}
