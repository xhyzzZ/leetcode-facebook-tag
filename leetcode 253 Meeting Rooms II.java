//leetcode 253 Meeting Rooms II

/*
time: O(n)
space: O(n)
*/
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for(int i = 0; i < intervals.length; i++) {
        	starts[i] = intervals[i].start;
        	ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int res = 0;
        int end = 0;
        for(int i = 0; i < intervals.length; i++) {
        	if(starts[i] < ends[end]) {
        		res++;
        	} else end++;
        }
        return res;
    }
}