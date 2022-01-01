// leetcode 871 Minimum Number of Refueling Stops

/*
time: O(nlogn)
space: O(n)
*/

priority queue
class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curFarthest = startFuel, refuel = 0;
	    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
	    for (int[] station : stations) {
	        // check if we can reach this station
	        // if we cannot reach this station, refuel the gas from the previous station with most gas
	        // redo the operation until we get enough gas to reach this station
	        while (curFarthest < station[0]) {
	            if (pq.isEmpty()) return -1; // if we reful in each station but still cannot reach this station, return -1
	            curFarthest += pq.poll();
	            refuel++;
	        }
	        pq.offer(station[1]);
	    }
	    // now we have reached the last station, check if we can reach the target
	    while (curFarthest < target) {
	        if (pq.isEmpty()) return -1;
	        curFarthest += pq.poll();
	        refuel++;
	    }
	    return refuel;
    }
}