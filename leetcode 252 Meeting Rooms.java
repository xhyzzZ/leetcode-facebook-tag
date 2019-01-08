//leetcode 252 Meeting Rooms

/*
time: O(nlogn)
space: O(1)
*/

public class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, (x, y) -> x.start - y.start);
        for(int i = 1; i < intervals.length; i++) {
        	if(intervals[i - 1].end > intervals[i].start) {
        		return false;
        	}
        }
        return true;
    }
}