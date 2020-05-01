//leetcode 323 Number of Connected Components in an Undirected Graph

/*
time: O()
space: O()
*/
union find
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
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            uf.union(x, y);
        }
        return uf.count;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
	    for(int i = 0; i < n; i++) roots[i] = i; 

	    for(int[] e : edges) {
	        int root1 = find(roots, e[0]);
	        int root2 = find(roots, e[1]);
	        if(root1 != root2) {      
	            roots[root1] = root2;  // union
	            n--;
	        }
	    }
	    return n;
	}

	public int find(int[] roots, int id) {
	    while(roots[id] != id) {
	        roots[id] = roots[roots[id]];  // optional: path compression
	        id = roots[id];
	    }
	    return id;
    }
}

dfs
public class Solution {
    
    public int countComponents(int n, int[][] edges) {
        if (n <= 1) {
            return n;
        }
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(visited, i, adjList);
            }
        }
        
        return count;
    }
    
    public void dfs(boolean[] visited, int index, List<List<Integer>> adjList) {
        visited[index] = true;
        for (int i : adjList.get(index)) {
            if (!visited[i]) {
                dfs(visited, i, adjList);
            }
        }
    }
}