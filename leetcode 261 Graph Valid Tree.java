
//leetcode 261 Graph Valid Tree

/*
time: O(edges * nodes)
space: O(n)
*/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
        	graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
        	graph.get(edges[i][0]).add(edges[i][1]);
        	graph.get(edges[i][1]).add(edges[i][0]);

        }
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);

        boolean res = helper(graph, visited, 0, -1);
        if(res == false) return false;
        return visited.size() == n ? true : false;
    }

    private boolean helper(List<List<Integer>> graph, HashSet<Integer> visited, int node, int parent) {
    	List<Integer> sub = graph.get(node);
    	for(int v : sub) {
    		if(v == parent) continue;
    		if(visited.contains(v)) return false;
    		visited.add(v);
    		boolean res = helper(graph, visited, v, node);
    		if(res == false) return false;
    	}
    	return true;
    }
}