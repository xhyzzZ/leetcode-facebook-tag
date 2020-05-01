//leetcode 317 Shortest Distance from All Buildings

/*
time: O()

space: O()
*/

public class Solution {
    public int shortestDistance(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return -1;
        }
        int col = grid[0].length;
        int[][] record1 = new int[row][col]; // visited num
        int[][] record2 = new int[row][col]; // distance
        int num1 = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 1) {
                    num1++;
                    boolean[][] visited = new boolean[row][col];
                    Queue<int[]> queue = new LinkedList<int[]>();
                    queue.offer(new int[]{r, c});
                    int dist = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int i = 0; i < size; i++) {
                            int[] node = queue.poll();
                            int x = node[0];
                            int y = node[1];
                            record2[x][y] += dist;
                            record1[x][y]++;
                            if (x > 0 && grid[x - 1][y] == 0 && !visited[x - 1][y]) {
                                queue.offer(new int[]{x - 1, y});
                                visited[x - 1][y] = true;
                            }
                            if (x + 1 < row && grid[x + 1][y] == 0 && !visited[x + 1][y]) {
                                queue.offer(new int[]{x + 1, y});
                                visited[x + 1][y] = true;
                            }
                            if (y > 0 && grid[x][y - 1] == 0 && !visited[x][y - 1]) {
                                queue.offer(new int[]{x, y - 1});
                                visited[x][y - 1] = true;
                            }
                            if (y + 1 < col && grid[x][y + 1] == 0 && !visited[x][y + 1]) {
                                queue.offer(new int[]{x, y + 1});
                                visited[x][y + 1] = true;
                            }
                        }
                        dist++;
                    }
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] == 0 && record1[r][c] == num1 && record2[r][c] < result) {
                    result = record2[r][c];
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}