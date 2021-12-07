// leetcode 994 Rotting Oranges

/*
time: O(mn)
space: O(mn)
*/

class Solution {
	private int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        int count_fresh = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 2) {
        			queue.offer(new int[] {i, j});
        		} else if (grid[i][j] == 1) {
        			count_fresh++;
        		}
        	}
        }

        if (count_fresh == 0) return 0;
        int count = 0;
        while (!queue.isEmpty()) {
        	count++;
        	int size = queue.size();
        	for (int i = 0; i < size; i++) {
        		int[] point = queue.poll();
        		for (int[] dir : dirs) {
        			int x = point[0] + dir[0];
        			int y = point[1] + dir[1];

        			if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0 
        				|| grid[x][y] == 2) {
        				continue;
        			}
        			grid[x][y] = 2;
        			queue.offer(new int[] {x, y});
        			count_fresh--;
        		}
        	}
        }
        return count_fresh == 0 ? count - 1 : -1;
    }
}

