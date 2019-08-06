//leetcode 261 Graph Valid Tree

/*
time: O(edges * nodes)
space: O(n)
*/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length == 0) return false; 
        // initialize n isolated islands
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // perform union find
        for (int[] e : edges) {
            int x = findRoot(parent, e[0]);
            int y = findRoot(parent, e[1]);
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            // union
            parent[x] = y;
        }
        
        return edges.length == n - 1;
    }
    
    private int findRoot(int[] parent, int i) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        // initialize adjacency list
        List<List<Integer>> adjList = new ArrayList<List<Integer>>(n);
        // initialize vertices
        for (int i = 0; i < n; i++)
            adjList.add(i, new ArrayList<Integer>());
        // add edges    
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        // make sure there's no cycle
        if (hasCycle(adjList, 0, visited, -1))
            return false;
        // make sure all vertices are connected
        for (int i = 0; i < n; i++) {
            if (!visited[i]) 
                return false;
        }
        return true;
    }
    // check if an undirected graph has cycle started from vertex u
    private boolean hasCycle(List<List<Integer>> adjList, int u, boolean[] visited, int parent) {
        visited[u] = true;
        for (int i = 0; i < adjList.get(u).size(); i++) {
            int v = adjList.get(u).get(i); 
            if ((visited[v] && parent != v) || (!visited[v] && hasCycle(adjList, v, visited, u)))
                return true;
        }
        return false;
    }
}