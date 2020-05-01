//leetcode 435 Non-overlapping Intervals

/*
time: O(nlogn)
space: O()
*/

class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0)  return 0;

        Arrays.sort(intervals, new myComparator());
        int end = intervals[0].end;
        int count = 1;        

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= end) {
                end = intervals[i].end;
                count++;
            }
        }
        return intervals.length - count;
    }
    
    class myComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.end - b.end;
        }
    }
}