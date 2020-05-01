//leetcode 695 Max Area of Island

/*
time: O(mn)
space: O(1)
*/

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			int area = dfs(grid, i, j, m, n, 0);
        			max = Math.max(area, max);
        		}
        	}
        }
        return max;
    }

    private int dfs(int[][] grid, int i, int j, int m, int n, int area) {
    	if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return area;

    	grid[i][j] = 0;
    	return 1 + dfs(grid, i + 1, j, m, n, area) + dfs(grid, i - 1, j, m, n, area)
    	+ dfs(grid, i, j + 1, m, n, area) + dfs(grid, i, j - 1, m, n, area);
    }
}