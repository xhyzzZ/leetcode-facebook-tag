//leetcode 240 Search a 2D Matrix II

/*
time: O(n)
space: O(1)
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int rows = matrix.length;
        int cols = matrix[0].length;
        int x = rows - 1;
        int y = 0;

        while (x >= 0 && y < cols) {
        	int cur = matrix[x][y];
        	if (cur == target) {
        		return true;
        	} else if (cur < target) {
        		y++;
        	} else {
        		x--;
        	}
        }
        return false;
    }
}