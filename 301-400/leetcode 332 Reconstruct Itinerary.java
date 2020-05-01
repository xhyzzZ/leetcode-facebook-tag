//leetcode 332 Reconstruct Itinerary

/*
time: O(n + n + nlogn)
space: O(n)
*/

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        LinkedList<String> path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            flights.putIfAbsent(from, new PriorityQueue<>());
            flights.get(from).add(to);
        }
        dfs("JFK", flights, path);
        return path;
    }

    public void dfs(String departure, Map<String, PriorityQueue<String>> flights,
        LinkedList<String> path) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, path);
        }
        path.addFirst(departure);
    }
}