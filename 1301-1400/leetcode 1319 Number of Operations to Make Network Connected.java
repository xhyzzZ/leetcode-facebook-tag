// leetcode 1319 Number of Operations to Make Network Connected

/*
time: O(E * α(N))
space: O(V)
*/

class Solution {
    class UnionFind {
        private int count = 0;
        private int[] parent;
        private int cycle = 0;
        public UnionFind(int n) {
            count = n;
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int p) {
            if (parent[p] == p) return p;
            return find(parent[p]);
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) {
                cycle++;
                return;
            } else {
                parent[rootQ] = rootP;
            }
            count--;
        }
    }
    
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        for (int[] con : connections) {
            int x = con[0], y = con[1];
            uf.union(x, y);
        }
        int plan = uf.count - 1;
        return uf.cycle >= plan ? plan : -1;
        
    }
}