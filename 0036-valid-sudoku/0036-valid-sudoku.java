class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Arrays of HashSets for rows, columns, and boxes
        HashSet<Character>[] rows = new HashSet[9];
        HashSet<Character>[] cols = new HashSet[9];
        HashSet<Character>[] boxes = new HashSet[9];

        // Initialize all sets
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        // Traverse each cell
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Ignore empty cells
                if (num == '.') continue;

                int boxIndex = (i / 3) * 3 + (j / 3); // which 3x3 box we are in

                // Check duplicates
                if (rows[i].contains(num) || cols[j].contains(num) || boxes[boxIndex].contains(num)) {
                    return false; // duplicate found
                }

                // Add to sets
                rows[i].add(num);
                cols[j].add(num);
                boxes[boxIndex].add(num);
            }
        }
        return true;
    }
}
