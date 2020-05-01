// leetcode 1245 Tree Diameter

/*
time: O(n)
space: O(n)
First BFS to find an end point of the longest path and second BFS 
from this end point to find the actual longest path.
*/

class Solution {
    class Node {
        int value;
        int distance;

        Node(int node, int distance) {
            this.value = node;
            this.distance = distance;
        }
    }

    public int treeDiameter(int[][] edges) {
        int n = edges.length + 1;

        LinkedList<Integer>[] adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        Node start = bfs(0, n, adj);
        return bfs(start.value, n, adj).distance;

    }

    private Node bfs(int u, int n, LinkedList<Integer>[] adj) {
        int[] distance = new int[n];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(u);
        distance[u] = 0;
        while (!queue.isEmpty()) {
            int poll = queue.poll();
            for (int i = 0; i < adj[poll].size(); i++) {
                int v = adj[poll].get(i);
                if (distance[v] == -1) {
                    queue.add(v);
                    distance[v] = distance[poll] + 1;
                }
            }
        }

        int maxDistance = 0;
        int val = 0;
        for (int i = 0; i < n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                val = i;
            }
        }
        return new Node(val, maxDistance);
    }
}