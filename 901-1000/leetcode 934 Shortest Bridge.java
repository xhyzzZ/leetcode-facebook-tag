// leetcode 934 Shortest Bridge

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int shortestBridge(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        // 1. dfs to find an island, mark it in `visited`
        for (int i = 0; i < m; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, queue, i, j);
                    found = true;
                    break;
                }
            }
        }

        // 2. bfs to expand this island
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && y >= 0 && x < m && y < n && !visited[x][y]) {
                        if (grid[x][y] == 1) return step;
                        queue.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] grid, boolean[][] visited, Queue<int[]> queue, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) return;
        visited[i][j] = true;
        queue.offer(new int[]{i, j});
        for (int[] dir : dirs) {
            dfs(grid, visited, queue, i + dir[0], j + dir[1]);
        }
    }
}