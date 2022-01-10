// leetcode 1976 Number of Ways to Arrive at Destination

/*
time: O(M * logN + N)
space: O(N + M)
*/

class Solution {
    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) graph.put(i, new ArrayList<>());
        for (int[] road : roads) {
        	int from = road[0], to = road[1], time = road[2];
        	graph.get(from).add(new int[] {to, time});
        	graph.get(to).add(new int[] {from, time});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] ways = new int[n];
        ways[0] = 1;
        dist[0] = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)-> a[0] - b[0]);
        // dist, src
        minHeap.offer(new int[] {0, 0});  
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int d = top[0], u = top[1];
            if (d > dist[u]) continue;
            for (int[] nei : graph.get(u)) {
                int v = nei[0], time = nei[1];
                if (dist[v] > d + time) {
                    dist[v] = d + time;
                    ways[v] = ways[u];
                    minHeap.add(new int[] {dist[v], v});
                } else if (dist[v] == d + time) {
                    ways[v] = (ways[v] + ways[u]) % 1_000_000_007;
                }
            }
        }
        return ways[n - 1];
    }
}