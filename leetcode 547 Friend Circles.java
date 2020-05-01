// leetcode 547 Friend Circles

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
    public int findCircleNum(int[][] M) {
    	int n = M.length;
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count();
    }
}

class Solution {
    public int findCircleNum(int[][] M) {
    	//visited[i] means if ith person is visited in this algorithm
        boolean[] visited = new boolean[M.length]; 
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] M, boolean[] visited, int person) {
        for (int other = 0; other < M.length; other++) {
            if (M[person][other] == 1 && !visited[other]) {
                //We found an unvisited person in the current friend cycle 
                visited[other] = true;
                //Start DFS on this new found person
                dfs(M, visited, other); 
            }
        }
    }
}