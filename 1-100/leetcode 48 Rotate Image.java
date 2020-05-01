//leetcode 48 Rotate Image


/*
time: O(m * n)
space: O(1)

*/

public class Solution {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0) return;
		int n = matrix.length;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i - 1; j++) {
				swap(matrix, i, j, j, n - 1 - i);
				swap(matrix, i, j, n - 1 - i, n - 1 - j);
				swap(matrix, i, j, n - 1 - j, i);
			}
		}
	}
	
	private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
		int tmp = matrix[x1][y1];
		matrix[x1][y1] = matrix[x2][y2];
		matrix[x2][y2] = tmp;
	}
}