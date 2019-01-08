//leetcode 56 Merge Intervals


/*
time: O(nlogn)
space: O(n)
*/
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        // Sort by ascending starting point using an anonymous Comparator
        Collection.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> res = new ArrayList<>();
        for(Interval interval : intervals) {
        	if(interval.start <= end) {        // Overlapping intervals, move the end if needed
        		end = Math.max(end, interval.end);
        	} else {                           // Disjoint intervals, add the previous one and reset bounds
        		res.add(new Interval(start, end));
        		start = interval.start;
        		end = interval.end;
        	}
        }
        res.add(new Interval(start, end)); //最后一次没算进去
        return res;
    }


/*
time: O(n)
space: O(n)
*/
    //sort start & end
    public List<Interval> merge(List<Interval> intervals) {
    // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
    }
    Arrays.sort(starts);
    Arrays.sort(ends);
    // loop through
    List<Interval> res = new ArrayList<Interval>();
    for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
        if (i == n - 1 || starts[i + 1] > ends[i]) {
            res.add(new Interval(starts[j], ends[i]));
            j = i + 1;
        }
    }
    return res;
}
}