// leetcode 1928 Minimum Cost to Reach Destination in Time

/*
time: O()
space: O()
*/

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;

        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);

        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] edge : edges) {
			graph.putIfAbsent(edge[0], new ArrayList<>());
			graph.putIfAbsent(edge[1], new ArrayList<>());
			graph.get(edge[0]).add(new int[] {edge[1], edge[2]});
			graph.get(edge[1]).add(new int[] {edge[0], edge[2]});
		}

		// make a minheap acccording to min passingFees
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		// node, total passingFees till here, time spend till here
        pq.offer(new int[] {0, passingFees[0], 0}); 
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0];
            int fee = top[1];
            int time = top[2];
            
            if (time >= minTime[node] || time > maxTime) continue;
            if (node == n - 1) return fee;
            
            minTime[node] = time;
            
            for (int[] nei : graph.get(node)) {
                int nei_node = nei[0];
                int nei_time = time + nei[1];
                int nei_fee = fee + passingFees[nei_node];
                
                pq.offer(new int[] {nei_node, nei_fee, nei_time});
            }
        }
        return -1;
    }
}