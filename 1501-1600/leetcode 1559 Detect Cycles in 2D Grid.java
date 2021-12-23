// leetcode 1559 Detect Cycles in 2D Grid

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    public static final int[][] dirs = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean hasCycle = false;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (!visited[i][j]) {
                    hasCycle |= dfs(i, j, -1, -1, n, m, visited, grid, grid[i][j]);
                }
            }
        }
        return hasCycle;
    }
    
    private boolean dfs(int curX, int curY, int lastX, int lastY, int n, int m, boolean[][] visited, char[][] grid, char startChar) {
        visited[curX][curY] = true;
        boolean hasCycle = false;
        // Visit all directions
        for (int[] dir : dirs) {
            int newX = curX + dir[0];
            int newY = curY + dir[1];
            // Valid point?
            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                // Don't visit last visited point
                if (!(newX == lastX && newY == lastY)) {
                    // Only visit nodes that equal start character
                    if (grid[newX][newY] == startChar) {
                        if (visited[newX][newY]) {
                            // Still visited? There is a cycle.
                            return true;
                        } else {
                            hasCycle |= dfs(newX, newY, curX, curY, n, m, visited, grid, startChar);
                        }
                    }
                }
            }
        }
        return hasCycle;
    }
}