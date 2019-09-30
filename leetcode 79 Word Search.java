//leetcode 79 Word Search


/*
time: O(mn)
space: O(1)
*/
public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (exist(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean exist(char[][] board, int i, int j, String word, int start) {
        if (start = word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(start)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = exist(board, i + 1, j, word, start + 1) || 
                    exist(board, i - 1, j, word, start + 1) ||
                    exist(board, i, j + 1, word, start + 1) ||
                    exist(board, i, j - 1, word, start + 1);
            board[i][j] = c;
            return res; 
        }
        return false;
    }
}