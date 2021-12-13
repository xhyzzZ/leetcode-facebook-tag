// leetcode 723 Candy Crush

/*
time: O((mn)^2)
space: O(1)
*/

class Solution {
    public int[][] candyCrush(int[][] board) {
        int m = board.length, n = board[0].length;
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int val = Math.abs(board[i][j]);
                    if (val == 0) continue;
                    if (j < n - 2 && Math.abs(board[i][j + 1]) == val && Math.abs(board[i][j + 2]) == val) {
                        found = true;
                        int ind = j;
                        while (ind < n && Math.abs(board[i][ind]) == val) board[i][ind++] = -val;
                    }
                    if (i < m - 2 && Math.abs(board[i + 1][j]) == val && Math.abs(board[i + 2][j]) == val) {
                        found = true;
                        int ind = i;
                        while (ind < m && Math.abs(board[ind][j]) == val) board[ind++][j] = -val;           
                    }
                }
            }
            if (found) { // move positive values to the bottom, then set the rest to 0
                for (int j = 0; j < n; j++) {
                    int storeInd = m - 1;
                    for (int i = m - 1; i >= 0; i--) {
                        if (board[i][j] > 0) {
                            board[storeInd--][j] = board[i][j];
                        }
                    }
                    for (int k = storeInd; k >= 0; k--) board[k][j] = 0;
                }
            }
        }
        return board;
    }
}