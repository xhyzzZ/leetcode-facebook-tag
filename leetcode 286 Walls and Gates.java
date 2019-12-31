//leetcode 286 Walls and Gates

/*
time: O(mn)
space: O(n)
*/

class Solution {
    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0 || rooms[0].length == 0) return;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) queue.add(new int[]{i, j});
            }
        }
        while (!queue.isEmpty()) {
            int[] top = queue.remove();
            int x = top[0], y = top[1];
            for (int[] dir : dirs) {
                int newX = x + dir[0], newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= rooms.length || newY >= rooms[0].length) continue;
                if (rooms[newX][newY] == Integer.MAX_VALUE) {
                    rooms[newX][newY] = rooms[x][y] + 1;
                    queue.offer(new int[] {newX, newY});
                }
            }
        }
    }
}