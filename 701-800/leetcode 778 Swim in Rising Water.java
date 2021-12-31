// leetcode 778 Swim in Rising Water

/*
time: O(N^2logN)
space: O(N^2)
*/

priority queue
class Solution {
    private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        int len = grid.length;
        boolean[][] visited = new boolean[len][len];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> grid[a[0]][a[1]] - grid[b[0]][b[1]]);
        pq.offer(new int[] {0, 0});
        visited[0][0] = true;
        int res = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int row = top[0], col = top[1];
            res = Math.max(res, grid[row][col]);
            if (row == len - 1 && col == len - 1) break;

            for (int[] dir : dirs) {
                int newR = row + dir[0], newC = col + dir[1];
                if (0 <= newR && newR < len && 0 <= newC && newC < len && !visited[newR][newC]) {
                    pq.offer(new int[] {newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }

        return res;
    }
}

/*
time: O(N^2logN)
space: O(N^2)
*/

binary search + dfs
class Solution {
	private static final int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int swimInWater(int[][] grid) {
        int len = grid.length;
        int lo = grid[0][0], hi = len * len;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!possible(mi, grid)) {
                lo = mi + 1;
            } else {
                hi = mi;
            }
        }
        return lo;
    }

    private boolean possible(int target, int[][] grid) {
        int len = grid.length;
        Set<Integer> seen = new HashSet<>();
        seen.add(0);

        Stack<Integer> stack = new Stack();
        stack.add(0);

        while (!stack.empty()) {
            int k = stack.pop();
            int row = k / len, col = k % len;
            if (row == len-1 && col == len-1) return true;

            for (int[] dir : dirs) {
                int newR = row + dir[0], newC = col + dir[1];
                int newK = newR * len + newC;
                if (0 <= newR && newR < len && 0 <= newC && newC < len && !seen.contains(newK) && grid[newR][newC] <= target) {
                    stack.add(newK);
                    seen.add(newK);
                }
            }
        }

        return false;
    }
}

/*
time: O(N^2logN^2)
space: O(N^2)
*/

union find
class UnionFind {
    private int count = 0;
    private int[] parent, rank;
    
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    
    // find(...) amortizes to O(α(N))
    public int find(int p) {
        if (parent[p] == p) return p;
        return find(parent[p]);
    }
    
    // path compression and union by rank to optimize
    public boolean union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return false;
        if (rank[rootQ] > rank[rootP]) {
            parent[rootP] = rootQ;
        } else if (rank[rootQ] < rank[rootP]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
        return true;
    }
    
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}

public int swimInWater(int[][] grid) {
    int len = grid.length;
    UnionFind uf = new UnionFind(len * len);
    int time = 0;
    while (!uf.isConnected(0, len * len - 1)) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (grid[i][j] > time) continue;
                if (i < len - 1 && grid[i + 1][j] <= time) uf.union(i * len + j, i * len + j + len);
                if (j < len - 1 && grid[i][j + 1] <= time) uf.union(i * len + j, i * len + j + 1);
            }
        }
        time++;
    }
    return time - 1;
}