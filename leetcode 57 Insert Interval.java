//leetcode 57 Insert Interval

/*
time: O(n)
space: O(1)
*/

public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<>();
        int i = 0;
        int start = newInterval.start;
        int end = newInterval.end;

        while (i < intervals.size() && intervals.get(i).end < start) {
            res.add(intervals.get(i++));
        }

        while (i < intervals.size() && intervals.get(i).start <= end) {
            start = Math.min(start, intervals.get(i).start);
            end = Math.max(end, intervals.get(i).end);
            i++;
        }
        res.add(new Interval(start,end)); 

        while (i < intervals.size()) res.add(intervals.get(i++)); 
        return res;
    }
}