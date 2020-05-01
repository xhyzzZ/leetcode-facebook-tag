//leetcode 1091 Shortest Path in Binary Matrix

/*
time: O()
space: O()
*/

class Solution {

	private int dir[][] = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, 
									{1, -1}, {-1, 1}, {-1, -1}, {1, 1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
        	return -1;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        int res = 0;
        while (!queue.isEmpty()) {
        	for (int i = queue.size(); i > 0; i--) {
        		int[] cur = queue.poll();
        		if (cur[0] == n - 1 && cur[1] == n - 1) {
        			return res + 1;
        		}

        		for (int k = 0; k < 8; k++) {
        			int x0 = cur[0] + dir[k][0];
        			int y0 = cur[1] + dir[k][1];

        			if (x0 >= 0 && x0 < n && y0 >= 0 && y0 < n && grid[x0][y0] == 0) {
        				queue.offer(new int[] {x0, y0});
        				grid[x0][y0] = ~grid[x0][y0];
        			} 
        		}
        	}
        	res++;
        }
        return -1;
    }
}