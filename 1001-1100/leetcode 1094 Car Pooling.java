// leetcode 1094 Car Pooling

/*
time: O(logn)
space: O(n)
*/

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips, Comparator.comparing(trip -> trip[1]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(trip -> trip[2]));
        for (int[] trip : trips) {
            while (!pq.isEmpty() && trip[1] >= pq.peek()[2]) // any passengers need to get off?
                capacity += pq.poll()[0]; // more capacity as passengers out.
            capacity -= trip[0]; // less capacity as passengers in.
            if (capacity < 0) return false; // not enough capacity.
            pq.offer(trip); // put into PriorityQueue the infomation at current location.
        }
        return true;
    }
}