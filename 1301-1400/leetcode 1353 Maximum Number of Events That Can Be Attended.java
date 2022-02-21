// leetcode 1353 Maximum Number of Events That Can Be Attended

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int maxEvents(int[][] events) {
        // sort by start time
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        
        // return the events ending earlier first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int ans = 0;
        int currentTime = events[0][0];
        
        for (int i = 0; i < events.length; i++) {
            // when the next event up has a time greater than our current time
            // we can pop some older events off our heap, time permitting
            while (pq.size() > 0 && events[i][0] > currentTime) {
                int[] endTime = pq.poll();
                // if events finishing first have already passed, keep polling until we get one we can attend
                while (pq.size() > 0 && endTime[1] < currentTime) endTime = pq.poll();
        
                if (endTime[1] >= currentTime) ans++;
                currentTime++;
            }
            
            currentTime = events[i][0];
            pq.add(events[i]);
        }   
        // clear the remaining events off the heap
        while (pq.size() > 0) {
            int[] endTime = pq.poll();
            while (pq.size() > 0 && endTime[1] < currentTime) endTime = pq.poll();
            if (endTime[1] >= currentTime) ans++;
            currentTime++;
        }
        return ans;
    }
}