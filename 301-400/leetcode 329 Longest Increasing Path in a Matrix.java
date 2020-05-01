//leetcode 329 Longest Increasing Path in a Matrix

/*
time: O(mn)
space: O(mn)

1. Do DFS from every cell
2. Compare every 4 direction and skip cells that are out of boundary or smaller
3. Get matrix max from every cell's max
4. Use matrix[x][y] <= matrix[i][j] so we don't need a visited[m][n] array
5. The key is to cache the distance because it's highly possible to
*/

class Solution {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

	public int longestIncreasingPath(int[][] matrix) {
	    if (matrix.length == 0) return 0;
	    int m = matrix.length, n = matrix[0].length;
	    int[][] cache = new int[m][n];
	    int max = 1;
	    for (int i = 0; i < m; i++) {
	        for (int j = 0; j < n; j++) {
	            int len = dfs(matrix, i, j, m, n, cache);
	            max = Math.max(max, len);
	        }
	    }   
	    return max;
	}

	public int dfs(int[][] matrix, int i, int j, int m, int n, int[][] cache) {
	    if (cache[i][j] != 0) return cache[i][j];
	    int max = 1;
	    for (int[] dir : dirs) {
	        int x = i + dir[0], y = j + dir[1];
	        if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
	        int len = 1 + dfs(matrix, x, y, m, n, cache);
	        max = Math.max(max, len);
	    }
	    cache[i][j] = max;
	    return max;
	}
}