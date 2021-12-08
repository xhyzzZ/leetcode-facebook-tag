// leetcode 1102 Path With Maximum Minimum Value

/*
time: O(mnlogmn)
space: O(mn)
*/

class Solution {
    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public int maximumMinimumPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[2] - a[2]);
        pq.offer(new int[] {0, 0, grid[0][0]});
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            int x = cell[0];
            int y = cell[1];
            if (x == m - 1 && y == n - 1) {
                return cell[2];
            }
            visited[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
        
                if (newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY]) continue;
                pq.offer(new int[] {newX, newY, Math.min(cell[2], grid[newX][newY])});
            }
        }
        return -1;
    }
}