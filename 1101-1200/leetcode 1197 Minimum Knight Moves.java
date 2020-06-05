// leetcode 1197 Minimum Knight Moves

/*
time: O(8 * abs(x)* abs(y))
space: O()
*/

class Solution {
    private final static int[][] dirs = {{1, 2}, {1, -2}, {-1, 2}, {-1, -2}, {2, -1}, {2, 1}, {-2, -1}, {-2, 1}};
    public int minKnightMoves(int x, int y) {
    	x = Math.abs(x);
        y = Math.abs(y);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});

        Set<String> visited = new HashSet<>();
        visited.add("0,0");
       
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int r = cur[0];
                int c = cur[1];
                if (r == x && c == y) return count;
                for (int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (!visited.contains(nr + "," + nc) && nr >= -1 && nc >= -1) {
                        q.add(new int[] {nr, nc});
                        visited.add(nr + "," + nc);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}