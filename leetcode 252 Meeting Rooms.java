//leetcode 252 Meeting Rooms

/*
time: O(nlogn)
space: O(1)
*/

public class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length < 2) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i - 1][1] > intervals[i][0]) {
                return false;
            }
        }
        return true;
    }
}