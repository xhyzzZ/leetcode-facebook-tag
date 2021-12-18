// leetcode 827 Making A Large Island

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public int largestIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0, nextColor = 2;
        // the size of connected component corresponding to color
        Map<Integer, Integer> componentSize = new HashMap<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != 1) continue;
                paint(grid, r, c, nextColor);
                nextColor++;
                res = Math.max(res, componentSize.get(nextColor - 1));
            }
        }

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] != 0) continue;
                Set<Integer> neighborColors = new HashSet<>();
                for (int[] dir : dirs) {
                    int nextR = r + dir[0], nextC = c + dir[1];
                    if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || grid[nextR][nextC] == 0) continue;
                    neighborColors.add(grid[nextR][nextC]);
                }
                int size = 1;
                for (int color : neighborColors) size += componentSize.getOrDefault(color, 0);
                res = Math.max(res, size);
            }
        }

        return res;
    }

    private void paint(int[][] grid, int r, int c, int color, Map<Integer, Integer> componentSize) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) return;
        grid[r][c] = color;
        componentSize.put(color, componentSize.getOrDefault(color, 0) + 1);
        for (int[] dir : dirs) {
            paint(grid, dir[0] + r, dir[1] + c, color, componentSize);
        }
    }
}