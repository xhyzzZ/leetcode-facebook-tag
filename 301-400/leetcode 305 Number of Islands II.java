// leetcode 305 Number of Islands II

/*
time: O()
space: O()
*/

class UnionFind {
    private int[] parent;
    private int[] rank;
    
    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        Arrays.fill(parent, -1);
    }
    
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
        return true;
    }
    
    // find(...) amortizes to O(α(N))
    public int find(int p) {
        if (parent[p] == p) return p;
        return find(parent[p]);
    }
}

class Solution {
	private static final int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m == 0 || n == 0 || positions == null || positions.length == 0 || positions[0].length == 0) return res;
        UnionFind uf = new UnionFind(m * n);
        int count = 0;
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int p = x * n + y;
            if (uf.parent[p] != -1) {   // duplicate position
                res.add(count);
                continue;
            }
            uf.parent[p] = p;
            count++;
            for (int[] dir : dirs) {
                int r = x + dir[0];
                int c = y + dir[1];
                if (isValid(uf, m, n, r, c)) {
                    int q = r * n + c;
                    if (uf.union(p, q)) {
                        count--;
                    }
                }
            }
            res.add(count);
        }
        return res;
    }
    
    private boolean isValid(UnionFind uf, int m, int n, int r, int c) {
        if (r < 0 || c < 0 || r >= m || c >= n || uf.parent[r * n + c] == -1) return false;
        return true;
    }
}