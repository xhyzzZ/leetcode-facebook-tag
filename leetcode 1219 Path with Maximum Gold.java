// leetcode 1219 Path with Maximum Gold

/*
time: O(k * 4 ^ k + m * n) k = number of gold cells
space: O(m * n)
*/

class Solution {
    public int getMaximumGold(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0)
                    ans = Math.max(ans, dfs(grid, i, j, 0));
            }
        }
        return ans;
    }
    
    public int dfs(int[][] grid, int i, int j, int sum) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0) return sum;
        int val = grid[i][j];
        
        grid[i][j] = 0;
        int max = 0;
        max = Math.max(max, dfs(grid, i + 1, j, sum + val));
        max = Math.max(max, dfs(grid, i - 1, j, sum + val));
        max = Math.max(max, dfs(grid, i, j + 1, sum + val));
        max = Math.max(max, dfs(grid, i, j - 1, sum + val));
        
        grid[i][j] = val;
        return max;
    }
}