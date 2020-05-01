//leetcode 253 Meeting Rooms II

/*
time: O(nlogn)
space: O(n)
当我们开始一场会议时，我们需要加一个房间。在我们加房间之前，我们需要判断之前的会议是否结束
这就是为什么要检查starts[i] < ends[end]
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
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[end]) {
                res++;
            } else end++;
        }
        return res;
    }
}

class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        pq.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }
        return pq.size();
    }
}