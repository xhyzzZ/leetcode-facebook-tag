// leetcode 1162 As Far from Land as Possible

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int maxDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    queue.offer(new int[] {i, j});
                }
            }
        }

        int res = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                res = Math.max(res, grid[cur[0]][cur[1]] - 1);
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0], y = cur[1] + dir[1];
                    if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                        visited[x][y] = true;
                        grid[x][y] = grid[cur[0]][cur[1]] + 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
        return res == 0 ? -1 : res;
    }
}