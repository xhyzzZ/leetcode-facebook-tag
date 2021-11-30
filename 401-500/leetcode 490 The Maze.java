// leetcode 490 The Maze

/*
time: O(mn)
space: O(mn)
*/

dfs
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

/*
time: O(mn)
space: O(mn)
*/

bfs
public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int[][] dirs={{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        Queue < int[] > queue = new LinkedList < > ();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int[] s = queue.remove();
            if (s[0] == destination[0] && s[1] == destination[1])
                return true;
            for (int[] dir: dirs) {
                int x = s[0] + dir[0];
                int y = s[1] + dir[1];
                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (!visited[x - dir[0]][y - dir[1]]) {
                    queue.add(new int[] {x - dir[0], y - dir[1]});
                    visited[x - dir[0]][y - dir[1]] = true;
                }
            }
        }
        return false;
    }
}