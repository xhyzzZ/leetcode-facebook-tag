// leetcode 815 Bus Routes

/*
time: O(V + E), where V is the total number of bus routes and E is the total number of bus stops.
space: O()
*/

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                graph.putIfAbsent(routes[i][j], new ArrayList<>());
                graph.get(routes[i][j]).add(i);
            }
        }

        Set<Integer> busTaken = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curStop = queue.poll();
                for (int bus : graph.get(curStop)) {
                    if (busTaken.contains(bus)) continue; // not take the same bus again...
                    busTaken.add(bus);
                    for (int nextStop : routes[bus]) {
                        if (visited.contains(nextStop)) continue; // not visited the same stop...
                        if (nextStop == target) return res;
                        queue.add(nextStop);
                        visited.add(nextStop);
                    }
                }
            }
        }
        return -1;
    }
}