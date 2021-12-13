// leetcode 886 Possible Bipartition

/*
time: O(v + e)
space: O(v + e)
*/

bfs
class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n + 1];
        List<List<Integer>> adj = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<Integer>());
        for (int[] d : dislikes) {
            adj.get(d[0]).add(d[1]);
            adj.get(d[1]).add(d[0]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) {
                color[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int nb : adj.get(cur)) {
                        if (color[nb] == 0) {
                            color[nb] = color[cur] == 1 ? 2 : 1;
                            queue.add(nb);
                        } else {
                            if (color[nb] == color[cur]) return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}