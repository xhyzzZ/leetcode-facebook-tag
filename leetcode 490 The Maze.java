//leetcode 490 The Maze

/*
time: O(mn)
space: O()
*/

class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] p, int[] destination, boolean[][] visited) {
        if (visited[p[0]][p[1]]) return false;
        if (p[0] == destination[0] && p[1] == destination[1]) return true;
        visited[p[0]][p[1]] = true;
        for (int[] dir : dirs) {
            int row = p[0];
            int col = p[1];
            while (isValid(maze, row + dir[0], col + dir[1])) {
                row += dir[0];
                col += dir[1];
            }
            if (dfs(maze, new int[] {row, col}, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValid(int[][] maze, int row, int col) {
        return row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] != 1;
    }
}