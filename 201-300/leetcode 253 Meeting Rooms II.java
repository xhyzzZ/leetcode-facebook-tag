// leetcode 253 Meeting Rooms II

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        // 当我们开始一场会议时，我们需要加一个房间。在我们加房间之前，我们需要判断之前的会议是否结束
        // 这就是为什么要检查starts[i] < ends[end]
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else end++;
        }
        return res;
    }
}

/*
time: O(nlogn)
space: O(n)
*/

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int max = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        for (int i = 0; i < intervals.length; i++){
            // if the current meeting starts right after 
            // there's no need for a new room, merge the interval
            
            // So, every time we want to check if any room is free or not, 
            // simply check the topmost element of the min heap as that would be the room that would 
            // get free the earliest out of all the other rooms currently occupied.
            // no overlap, then should update smallest end.
            while (!pq.isEmpty() && intervals[i][0] >= pq.peek()[1])
                pq.poll();
            pq.offer(intervals[i]);
            max = Math.max(max, pq.size());
        }
        
        return max;
    }
}