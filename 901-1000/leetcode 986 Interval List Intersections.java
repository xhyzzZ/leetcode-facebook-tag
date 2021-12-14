// leetcode 986 Interval List Intersections

/*
time: O(m + n)
space: O(n)
*/

class Solution {
    public Interval[] intervalIntersection(Interval[] firstList, Interval[] secondList) {
        if (firstList == null || firstList.length == 0 || secondList == null || secondList.length == 0) {
            return new Interval[] {};
        }
        
        int m = firstList.length, n = secondList.length;
        int i = 0, j = 0;
        List<Interval> res = new ArrayList<>();
        while (i < m && j < n) {
            Interval a = firstList[i];
            Interval b = firstList[j];

            // find the overlap... if there is any...
            int startMax = Math.max(a.start, b.start);
            int endMin = Math.min(a.end, b.end);
            
            if (endMin >= startMax) {
                res.add(new Interval(startMax, endMin));
            }
            
            // update the pointer with smaller end value...
            if (a.end == endMin) { 
                i++; 
            }
            if (b.end == endMin) { 
                j++; 
            }
        }
        return res.toArray(new Interval[0]);
    }
}

