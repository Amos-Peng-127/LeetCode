class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Brute Force
        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] box = new int[9];

            for (int j = 0; j < 9; j++) {
                // Rearrange and Check Row
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'] != 0) {
                        return false;
                    }
                    row[board[i][j] - '1'] = 1;
                }

                // Rearrange and Check Col
                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1'] != 0) {
                        return false;
                    }
                    col[board[j][i] - '1'] = 1;
                }

                // 3x3 Box Check
                int rowIndex = i / 3 * 3 + j / 3;
                int colIndex = i % 3 * 3 + j % 3;

                if (board[rowIndex][colIndex] != '.') {
                    int numBox = board[rowIndex][colIndex] - '1';
                    if (box[numBox] != 0) {
                        return false;
                    }
                    box[numBox] = 1;
                }
            }
        }

        return true;
    }
}