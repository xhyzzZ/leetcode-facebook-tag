//leetcode 36 Valid Sudoku



/*
time: O(n^2)
space: O(n)


0 1 2 3 4 5 6 7 8
0 0 0 3 3 3 6 6 6  rowIndex
0 3 6 0 3 6 0 3 6  colIndex

0 0 0 1 1 1 2 2 2  j / 3
0 1 2 0 1 2 0 1 2  j % 3
rowIndex, colIndex 相当于遍历大的九宫格
j / 3, j % 3 相当于遍历一个小的九宫格里的所有元素
add()代表里面是否有重复元素，如果有重复元素，加不进去，则返回false

*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
    	for(int i = 0; i < board.length; i++) {
    		HashSet<Character> rows = new HashSet<>();
    		HashSet<Character> cols = new HashSet<>();
    		HashSet<Character> cube = new HashSet<>();
    		for(int j = 0; j < board[0].length; j++) {
    			if(board[i][j] != '.' && !rows.add(board[i][j])) return false;
    			if(board[j][i] != '.' && !cols.add(board[j][i])) return false;

    			int rowIndex = 3 * (i / 3);
    			int colIndex = 3 * (i % 3);

    			if(board[rowIndex + j / 3][colIndex + j % 3] != '.' && !cube.add(board[rowIndex + j / 3][colIndex + j % 3]))
    				return false;
    		}
    	}
        return true;     
    }
}