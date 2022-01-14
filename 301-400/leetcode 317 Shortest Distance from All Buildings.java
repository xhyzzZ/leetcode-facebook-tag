// leetcode 317 Shortest Distance from All Buildings

/*
time: O(m^2n^2)
space: O(mn)
*/

class Solution {
    // BFS from Houses to Empty Land
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        int res = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;

        int totalHouses = 0;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];

        // Count houses and start bfs from each house.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalHouses++;
                    bfs(grid, distance, reach, i, j);
                }
            }
        }

        // Check all empty lands with houses count equal to total houses and find the min ans.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reach[i][j] == totalHouses) {
                    res = Math.min(res, distance[i][j]);
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private void bfs(int[][] grid, int[][] distance, int[][] reach, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;

        int steps = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];

                // Traverse the next cells which is not a blockage.
                for (int[] dir : dirs) {
                    int dx = x + dir[0];
                    int dy = y + dir[1];
                    if (dx < 0 || dx > m - 1 || dy < 0 || dy > n - 1 || grid[dx][dy] != 0 || visited[dx][dy]) continue;

                    queue.offer(new int[] {dx, dy});
                    visited[dx][dy] = true;
                    distance[dx][dy] += steps;
                    reach[dx][dy]++;
                }
            }

            // After traversing one level cells, increment the steps by 1.
            steps++;
        }
    }
}