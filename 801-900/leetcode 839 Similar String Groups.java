// leetcode 839 Similar String Groups

/*
time: O()
space: O()
*/

class Solution {
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
        
        public int find(int p) {
            if (parent[p] == p) return p;
            return find(parent[p]);
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;
            if (rank[rootQ] > rank[rootP]) {
                parent[rootP] = rootQ;
            } else if (rank[rootQ] < rank[rootP]) {
                parent[rootQ] = rootP;
            } else {
                parent[rootQ] = rootP;
                rank[rootP]++;
            }
            count--;
        }
        
        public int count() {
            return count;
        }
    }
    
    public int numSimilarGroups(String[] A) {
        int len = A.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (isSimilar(A[i], A[j])) uf.union(i, j);
            }
        }
        return uf.count;
    }
    
    public boolean isSimilar(String a, String b) {
        int res = 0, len = a.length();
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i) && ++res > 2) return false;
        } 
        return true;
    }
}