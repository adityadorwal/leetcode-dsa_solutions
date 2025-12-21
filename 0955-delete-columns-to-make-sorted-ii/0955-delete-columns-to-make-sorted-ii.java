class Solution {
    public int minDeletionSize(String[] strs) {

        int n = strs.length;
        int str_len = strs[0].length();

        boolean[] resolved = new boolean[n - 1];
        int unresolved = n - 1;
        int min_removal_col = 0;

        for (int i = 0; i < str_len && unresolved > 0; i++) {

            boolean delete = false;

            for (int r = 0; r < n - 1; r++) {
                if (!resolved[r] &&
                    strs[r].charAt(i) > strs[r + 1].charAt(i)) {
                    delete = true;
                    break;
                }
            }

            if (delete) {
                min_removal_col++;
            } else {
                for (int r = 0; r < n - 1; r++) {
                    if (!resolved[r] &&
                        strs[r].charAt(i) < strs[r + 1].charAt(i)) {
                        resolved[r] = true;
                        unresolved--;
                    }
                }
            }
        }

        return min_removal_col;
    }
}
