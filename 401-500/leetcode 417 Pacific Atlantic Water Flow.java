// leetcode 417 Pacific Atlantic Water Flow

/*
time: O(mn)
space: O(mn)
*/

class Solution {
    private static int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new LinkedList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) return res;
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, m - 1);
        }
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }
    
    public void dfs(int[][] heights, boolean[][] visited, int height, int x, int y) {
        int n = heights.length, m = heights[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] || heights[x][y] < height) return;
        visited[x][y] = true;
        for (int[] dir : dirs) {
            dfs(heights, visited, heights[x][y], x + dir[0], y + dir[1]);
        }
    }
}