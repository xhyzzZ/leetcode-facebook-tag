// leetcode 73 Set Matrix Zeroes

/*
time: O(m * n)
space: O(1)
*/

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return;
        int m = matrix.length;
        int n = matrix[0].length;

        boolean row = false;
        boolean col = false;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == 0) {
        			matrix[0][j] = 0;
        			matrix[i][0] = 0;
                    // using the first row and column as a memory to keep track of all the 0's in the entire matrix
        			if (i == 0) row = true;
        			if (j == 0) col = true;
        		}
        	}
        }

        for (int i = 1; i < m; i++) {
        	for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (row) {
        	for (int j = 0; j < n; j++) {
        		matrix[0][j] = 0;
        	}
        }
        if (col) {
        	for (int i = 0; i < m; i++) {
        		matrix[i][0] = 0;
        	}
        }
    }
}